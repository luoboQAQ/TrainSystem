package top.lbqaq.model;

import lombok.Data;

@Data
public class Admin {
    private Long id;

    /**
    * 用户名
    */
    private String name;

    /**
    * 密码
    */
    private String password;
}