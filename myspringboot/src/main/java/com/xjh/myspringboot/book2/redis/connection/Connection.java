package com.xjh.myspringboot.book2.redis.connection;

import lombok.Data;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/2/18 7:59
 * @Description: 自定义redis客户端
 */
@Data
public class Connection {

    private String host;
    private Integer port;
    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;

    public Connection(String host, Integer port) {
        this.host = host;
        this.port = port;

    }
    /**
     * 建立连接
     * @return
     */
    public boolean connection(){
        try {
            socket = new Socket(host,port);
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 发送数据
     * @param data
     * @return
     */
    public String sendCommand(byte[] data){
        byte[] result = new byte[1024];
        try {
            outputStream.write(data);
            outputStream.flush();

            while(inputStream.read(result)>0){
              return new String(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        }
        return null;
    }
}
