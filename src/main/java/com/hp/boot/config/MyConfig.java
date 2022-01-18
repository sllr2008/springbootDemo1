package com.hp.boot.config;

import com.hp.boot.bean.NewCar;
import com.hp.boot.bean.Pet;
import com.hp.boot.bean.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 */
//@Configuration(proxyBeanMethods = false) // //告诉SpringBoot这是一个配置类 == 配置文件
@Configuration
@Import({User.class})
@ImportResource("classpath:beans.xml") //将beans.xml全部组件导入
@EnableConfigurationProperties(NewCar.class)
//1、开启NewCar配置绑定功能
//2、把这个NewCar这个组件自动注册到容器中
public class MyConfig {

    @Bean("pet") //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public Pet getPet(){
        return new Pet();
    }
}
