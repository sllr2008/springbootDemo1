package com.hp.boot;

import com.hp.boot.bean.Car;
import com.hp.boot.bean.NewCar;
import com.hp.boot.bean.NewCar1;
import com.hp.boot.bean.Pet;
import com.hp.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.Soundbank;

/**
 * @author hp
 * @create 2022-01-18 10:35
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        System.out.println("hot-fix");
        //1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("-------主程序下声明bean默认单例--------");

        Object car = run.getBean("pet1");
        System.out.println(car);

        System.out.println("-------配置类@Configuration--------");
        Object pet = run.getBean("pet");
        System.out.println(pet);
        System.out.println("-------MyConfig--------");
        MyConfig myconfig = run.getBean(MyConfig.class);
        System.out.println(myconfig); //com.hp.boot.config.MyConfig$$EnhancerBySpringCGLIB$$d3a5676f@6f012914

        Pet pet1 = myconfig.getPet();
        Pet pet2 = myconfig.getPet();
        System.out.println(pet1==pet2);//true


        System.out.println("--------获取beans.xml组件---------");
        boolean car111 = run.containsBean("car111");
        System.out.println(car111); //不导入为false

        System.out.println("--------属性绑定---------");
        System.out.println(run.getBean(NewCar.class));

        System.out.println("--------value属性绑定---------");
        System.out.println(run.getBean(NewCar1.class));
    }

    @Bean("pet1")
    public Pet getPet(){
        return  new Pet("zs");
    }
}

