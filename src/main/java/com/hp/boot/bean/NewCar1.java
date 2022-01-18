package com.hp.boot.bean;


import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
@ToString
@Data
@Component
public class NewCar1 {

    @Value("${mycar.brand}")
    private String brand;
    @Value("${mycar.price}")
    private Integer price;


}
