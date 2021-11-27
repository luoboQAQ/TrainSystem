package top.lbqaq.dto;

import lombok.Data;

/**
 * @author luoboQAQ
 * @Date 2021/11/11
 */
@Data
public class OrderDTO {
    /**
     * 订票数量
     */
    private Integer number;

    /**
     * 订票人id
     */
    private Long userId;

    /**
     * 列车id
     */
    private String trainId;

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

    /**
     * 是否订过票
     */
    private Boolean hasOrder;
}
