package com.xjh.myspringboot.book2.redis;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/2/19 8:04
 * @Description:
 */
public class RedisServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6379);
        Socket socket = serverSocket.accept();
        byte[] bytes = new byte[1024];
        socket.getInputStream().read(bytes);
        System.out.println(new String(bytes));
    }
}
