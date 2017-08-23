package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedSystem {
	private Map<String, Object> cache = new HashMap<String, Object>();
	
	ReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public Object get(String key)
	{	
		rwl.readLock().lock();
		Object value = cache.get(key);
		if (value==null) {
			rwl.readLock().unlock();
			rwl.writeLock().lock();
			if (value==null)//再次进行判断，防止多个写线程堵在这个地方重复写
			{
				value = "aaaa";
				cache.put(key, value);
			}
			//设置完成 释放写锁，恢复读写状态
			rwl.readLock().lock();
			rwl.writeLock().unlock();
		}
		//释放读锁
		rwl.readLock().unlock();
		return value;
	}
}
