package com.xjh.myspringboot.book2.redis.protocol;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/2/18 8:12
 * @Description:
 */
public class Protocol {

    private String ARRAY_COMMOND = "*";
    private String STRING_COMMOND = "$";
    private String BLANK = "\r\n";


    public byte[] changeCommond(Protocol.Commond commond, byte[]... args){
        StringBuilder sb = new StringBuilder();
        sb.append(ARRAY_COMMOND).append(args.length+1).append(BLANK);

        sb.append(STRING_COMMOND).append(commond.name().length()).append(BLANK);
        sb.append(commond).append(BLANK);
        for(byte[] b : args){
            sb.append(STRING_COMMOND).append(b.length).append(BLANK);
            sb.append(new String(b)).append(BLANK);
        }
        System.out.println("转换后的命令是：\r\n"+sb.toString());
         return  sb.toString().getBytes();
    }

    public enum Commond{
        SET, GET;
    }


    public static void main(String[] args) {
        new Protocol().changeCommond(Commond.SET,"xujianhong".getBytes(),"123".getBytes());
    }
}
