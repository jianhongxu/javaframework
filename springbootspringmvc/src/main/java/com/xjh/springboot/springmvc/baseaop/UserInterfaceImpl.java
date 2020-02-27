package com.xjh.springboot.springmvc.baseaop;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/2/27 12:39
 * @Description:
 */
public class UserInterfaceImpl implements UserInterface, RoleInterface {

    @Override
    public void add(String name) {
        System.out.println("添加用户成功:"+name);
    }

    @Override
    public String hasrole(String userName) {
        System.out.println("拥有的角色是:"+userName);
        return userName+"角色";
    }
}
