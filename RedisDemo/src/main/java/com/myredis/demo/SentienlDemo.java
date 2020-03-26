package com.myredis.demo;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

/**
 * redis 哨兵
 * 
 * @author Administrator
 *
 */
public class SentienlDemo {

	public static void main(String[] args){
		testSentinel();
	}
	
	private static void testSentinel(){
		String masterName = "mymaster";
		
		Set<String> sentinels = new HashSet<String>();
		sentinels.add("127.0.0.1:26379");
		
		JedisSentinelPool pool = new JedisSentinelPool(masterName, sentinels);
		Jedis jedis = pool.getResource();
		
		String myString = jedis.get("mykey");
		System.out.println(myString);
		
		try {
			Thread.sleep(1 * 6 * 10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//停掉主redis后再获取数据
		try {
			myString = jedis.get("mykey");
			System.out.println(myString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jedis.close();
	}
}
