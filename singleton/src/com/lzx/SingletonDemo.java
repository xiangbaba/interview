package com.lzx;

import java.sql.SQLOutput;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lzx
 * @create 2021-07-23 8:50
 * 单例设计模式 例:servlet,springBean对象(默认),Runtime类
 * 1.私有化构造器
 * 2.含有一个该类的静态变量来保存这个唯一的实例
 * 3.(1)直接暴露出来,(2)用静态变量的get方法来获取
 *
 * 饿汉式
 */
public class SingletonDemo {
	public static final SingletonDemo INSTANCE;
	static {
		INSTANCE= new SingletonDemo();
	}
	private SingletonDemo() {
	}
	public static void main(String[] args) {
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
		poolExecutor.execute(()->{
			for (int i = 0; i <7; i++) {
				System.out.println(INSTANCE);
			}
		});
		poolExecutor.shutdown();
	}

}
