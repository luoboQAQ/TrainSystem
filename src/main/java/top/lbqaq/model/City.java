package top.lbqaq.model;

import lombok.Data;

@Data
public class City {
    private Long id;

    /**
    * 城市名
    */
    private String cityName;

    /**
    * 是否为起始站
    */
    private Boolean start;

    /**
    * 是否为终点站
    */
    private Boolean end;
}