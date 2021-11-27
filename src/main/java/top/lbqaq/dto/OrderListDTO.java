package top.lbqaq.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author luoboQAQ
 * @Date 2021/11/15
 */
@Data
public class OrderListDTO {
    private Long id;

    /**
     * 订票时间
     */
    private Date time;

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
     * 出发时间
     */
    private Date startTime;
}
