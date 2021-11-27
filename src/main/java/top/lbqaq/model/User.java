package top.lbqaq.model;

import lombok.Data;

@Data
public class User {
    private Long id;

    /**
    * 用户名
    */
    private String name;

    /**
    * 密码
    */
    private String password;

    /**
    * 性别
    */
    private String sex;

    /**
    * 身份证号
    */
    private String idCard;

    /**
    * 真实姓名
    */
    private String realName;
}