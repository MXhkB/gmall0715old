package com.atguigu.gmall0715.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
    /*
     0. 创建JedisPool
     1. 获取Jedis
      */
    // 创建JedisPool
    private JedisPool jedisPool;

    // String host = "192.168.67.220";
    // 初始化连接池
    public void initJedisPool(String host,int post,int timeOut){
        //初始化配置参数
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //如果需要密码，则需要修改redis.conf配置文件。
        // 设置最大连接数
        jedisPoolConfig.setMaxTotal(200);

        // 如果说达到最大连接数，可以使进行进行排队等待
        jedisPoolConfig.setBlockWhenExhausted(true);

        // 设置等待的时间
        jedisPoolConfig.setMaxWaitMillis(10*1000);

        // 设置最小剩余数
        jedisPoolConfig.setMinIdle(10);

        // 表示获取到连接的时候，自检一下当前连接是否可以使用！
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPool = new JedisPool(jedisPoolConfig, host, post, timeOut);
    }
    //获取jedis方法
    public Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();

        return jedis;
    }
}
