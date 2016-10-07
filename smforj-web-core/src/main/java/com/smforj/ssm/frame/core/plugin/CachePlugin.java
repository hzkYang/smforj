package com.smforj.ssm.frame.core.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.mybatis.caches.ehcache.EhcacheCache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.smforj.ssm.frame.core.converter.IDataLoader;

/***
 * 
 * 
 * @author Haijun Gao 
 * @date 2016-9-5 下午5:17:00
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class CachePlugin {

	private static CacheManager cacheManager = createCacheManager();   

    /**
     * Looks for "/ehcache.xml" classpath resource and builds the relative
     * {@code CacheManager}; if it's no found or it is impossible to load it,
     * returns the default manager.
     *
     * @return the application cache manager.
     */
    private static CacheManager createCacheManager() {
        CacheManager cacheManager;
        InputStream input = EhcacheCache.class.getResourceAsStream("/ehcache.xml");

        if (input != null) {
            try {
                cacheManager = CacheManager.create(input);
            } catch (Throwable t) {
                cacheManager = CacheManager.create();
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        } else {
            cacheManager = CacheManager.create();
        }

        return cacheManager;
    }
	
    /***
     * 支持同包对象扩展
     * @param cacheManager
     * @date 2016-9-6 上午10:42:48
     */
	static void init(CacheManager cacheManager) {
		CachePlugin.cacheManager = cacheManager;
	}
	
	public static CacheManager getCacheManager() {
		return cacheManager;
	}
	
	static Cache getOrAddCache(String cacheName) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null) {
			synchronized(cacheManager) {
				cache = cacheManager.getCache(cacheName);
				if (cache == null) { 
					cacheManager.addCacheIfAbsent(cacheName);
					cache = cacheManager.getCache(cacheName); 
				}
			}
		}
		return cache;
	}
	
	public static void put(String cacheName, Object key, Object value) {
		getOrAddCache(cacheName).put(new Element(key, value));
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T get(String cacheName, Object key) {
		Element element = getOrAddCache(cacheName).get(key);
		return element != null ? (T)element.getObjectValue() : null;
	}
	
	@SuppressWarnings("rawtypes")
	public static List getKeys(String cacheName) {
		return getOrAddCache(cacheName).getKeys();
	}
	
	public static void remove(String cacheName, Object key) {
		getOrAddCache(cacheName).remove(key);
	}
	
	public static void removeAll(String cacheName) {
		getOrAddCache(cacheName).removeAll();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T get(String cacheName, Object key, IDataLoader dataLoader) {
		Object data = get(cacheName, key);
		if (data == null) {
			data = dataLoader.load();
			put(cacheName, key, data);
		}
		return (T)data;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T get(String cacheName, Object key, Class<? extends IDataLoader> dataLoaderClass) {
		Object data = get(cacheName, key);
		if (data == null) {
			try {
				IDataLoader dataLoader = dataLoaderClass.newInstance();
				data = dataLoader.load();
				put(cacheName, key, data);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return (T)data;
	}
}
