package cn.itsource.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: aigou-web-demo
 * @Package: cn.itsource.common
 * @ClassName: CommonApplication
 * @Author: Jenoves
 * @Description: ${description}
 * @Date: 2019/8/2 22:51
 * @Version: 1.0
 */
//开启SrpingBoot配置
@SpringBootApplication
//注册服务
@EnableEurekaClient
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class,args);
    }

}
