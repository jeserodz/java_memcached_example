
package com.jeserodz.memcached_example;

import java.io.IOException;
import java.net.InetSocketAddress;
import net.spy.memcached.MemcachedClient;

public class Application {
    public static void main(String[] args) throws IOException {
        // creating Memcached client object
        MemcachedClient jmemcache = new MemcachedClient(new InetSocketAddress("localhost", 11211));
        
        // adding a new key (key name: "key", key expiration: 60 secs, key value: "value")
        jmemcache.add("key", 60, "value");
        
        // getting the key value
        System.out.println("key = " + jmemcache.get("key").toString());
        
        if("value".equals(jmemcache.get("key"))) {
            System.out.println("Memcached is working! :D");
        }
        else {
            System.out.println("Memcached failed! :(");
        }
    }
}
