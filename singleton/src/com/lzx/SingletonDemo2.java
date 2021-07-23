package com.lzx;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lzx
 * @create 2021-07-23 9:15
 */
public class SingletonDemo2 {
	private static SingletonDemo2 instance ;

	private SingletonDemo2() {
	}

	public static SingletonDemo2 getInstance(){
		if (instance==null) {
			synchronized (SingletonDemo2.class) {
				if (instance==null){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new SingletonDemo2();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
		for (int i = 0; i < 7; i++) {
			poolExecutor.execute(()->{
				System.out.println(getInstance());
				System.out.println(Thread.currentThread().getName());
			});
		}
		poolExecutor.shutdown();
	}
}
