package com.myredis.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class RedisDemo {

	public static void main(String[] args) {
		testPing();
		testString();
		testHash();
		testList();
		testSet();
		testZSet();
	}

	private static void testPing() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("redis 连接成功!");
		System.out.println(jedis.ping());

		jedis.close();
	}

	private static void testString() {
		System.out.println("------ redis String -----");
		Jedis jedis = new Jedis("127.0.0.1", 6379);

		String key = "myString";
		long delLong = jedis.del(key);
		System.out.println("删除键:" + delLong);

		jedis.set(key, "123");
		System.out.println(jedis.get(key));

		jedis.close();
	}

	private static void testHash() {
		System.out.println("------ redis Hash -----");
		Jedis jedis = new Jedis("127.0.0.1", 6379);

		String key = "myHash";
		long delLong = jedis.del(key);
		System.out.println("删除键:" + delLong);

		jedis.hset(key, "file1", "v1");

		Map<String, String> map = new HashMap<String, String>();
		map.put("field2", "v2");
		map.put("File3", "v3");
		jedis.hmset(key, map);

		Map<String, String> result = jedis.hgetAll(key);
		Set<String> keys = result.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String k = it.next();
			System.out.println(k + ":" + result.get(k));
		}

		jedis.close();
	}

	private static void testList() {
		System.out.println("------ redis List -----");
		Jedis jedis = new Jedis("127.0.0.1", 6379);

		String key = "myList";
		long delLong = jedis.del(key);
		System.out.println("删除键:" + delLong);

		jedis.lpush(key, "list1", "list2", "v3");
		long len = jedis.llen(key);
		List<String> list = jedis.lrange(key, 0, len);
		System.out.println(Arrays.toString(list.toArray()));

		jedis.close();
	}

	private static void testSet() {
		System.out.println("------ redis Set -----");
		Jedis jedis = new Jedis("127.0.0.1", 6379);

		String key = "mySet";
		long delLong = jedis.del(key);
		System.out.println("删除键:" + delLong);

		jedis.sadd(key, "set1", "set2", "set2");
		Set<String> set = jedis.smembers(key);
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		jedis.close();
	}

	private static void testZSet() {
		System.out.println("------ redis ZSet -----");
		Jedis jedis = new Jedis("127.0.0.1", 6379);

		String key = "myZSet";
		long delLong = jedis.del(key);
		System.out.println("删除键:" + delLong);

		jedis.zadd(key, 0, "zset0");
		jedis.zadd(key, 2, "zset2");
		jedis.zadd(key, 1, "zset1");
		jedis.zincrby(key, 10, "xx");
		long count = jedis.zcard(key);
		Set<String> set = jedis.zrange(key, 0, count);
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		//
		System.out.println("返回有序集中指定分数区间内的成员，分数从高到低排序");
		Set<String> set2 = jedis.zrevrangeByScore(key, 100, -1);
		Iterator<String> it2 = set2.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}

		//
		System.out.println("// 按照销量多少排行，取出前10名");
		Set<Tuple> tuples = jedis.zrevrangeWithScores(key, 0, 9);
		for (Tuple tuple : tuples) {
			System.out.println(tuple.getElement() +":"+ tuple.getScore());
		}
		
		jedis.close();
	}
}
