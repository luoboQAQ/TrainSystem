package top.lbqaq.model;

import java.util.Date;
import lombok.Data;

@Data
public class Order {
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
}