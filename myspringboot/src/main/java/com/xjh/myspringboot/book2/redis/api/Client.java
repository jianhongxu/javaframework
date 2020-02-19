package com.xjh.myspringboot.book2.redis.api;

import com.xjh.myspringboot.book2.redis.connection.Connection;
import com.xjh.myspringboot.book2.redis.protocol.Protocol;
import redis.clients.jedis.Jedis;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/2/18 8:13
 * @Description:
 */
public class Client {

    Connection connectio;

    Protocol protocol;

    public Client() {
        connectio = new Connection("localhost",6379);
        connectio.connection();
        protocol =new Protocol();
    }

    public String set(String key, String value){
       return connectio.sendCommand(protocol.changeCommond(Protocol.Commond.SET, key.getBytes(), value.getBytes()));
    }

    public String get(String key){
        return connectio.sendCommand(protocol.changeCommond(Protocol.Commond.GET, key.getBytes()));
    }

    /**
     * redis底层通讯协议 reps
     * @param args
     */
    public static void main(String[] args) {

        Client client = new Client();
        System.out.println(client.set("xujianhong","12345678ceshi"));
        System.out.println("============================");
        System.out.println(client.get("xujianhong"));
        //Jedis jedis = new Jedis("localhost",6379);
        //jedis.set("xujianhong","8888888");
        /**
         * *3
         * $3
         * SET
         * $10
         * xujianhong
         * $7
         * 8888888
         *
         *
         */

    }
}
