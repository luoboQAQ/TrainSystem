package top.lbqaq.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author luoboQAQ
 * @Date 2021/11/11
 */
@Data
public class TrainDTO {
    private String id;

    /**
     * 车票价（分）
     */
    private Long price;

    /**
     * 剩余票数
     */
    private Integer number;

    /**
     * 到达时间
     */
    private Date arriveTime;

    /**
     * 出发时间
     */
    private Date startTime;

    /**
     * 目的地城市编号
     */
    private Long arriveCity;

    /**
     * 出发城市编号
     */
    private Long startCity;

    private String startCityName;

    private String arriveCityName;
}
