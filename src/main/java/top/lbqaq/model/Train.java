package top.lbqaq.model;

import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Train {
    private String id;

    /**
     * 车票价
     */
    private Long price;

    /**
     * 剩余票数
     */
    private Integer number;

    /**
     * 到达时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arriveTime;

    /**
     * 出发时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 目的地城市编号
     */
    private Long arriveCity;

    /**
     * 出发城市编号
     */
    private Long startCity;
}