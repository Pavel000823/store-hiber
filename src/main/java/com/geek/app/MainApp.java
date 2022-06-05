package com.geek.app;

import com.geek.app.config.ConfigApplication;
import com.geek.app.services.PurchasesService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApplication.class);
        PurchasesService service = context.getBean(PurchasesService.class);

        System.out.println(service.getProductListByConsumerId(1L).toString());
        System.out.println(service.getProductListByConsumerId(2L).toString());
        System.out.println(service.getProductListByConsumerId(3L).toString());
        System.out.println(service.getProductListByConsumerId(4L).toString());

        System.out.println(service.getConsumerByProductId(1L).toString());
        System.out.println(service.getConsumerByProductId(2L).toString());
        System.out.println(service.getConsumerByProductId(3L).toString());
        System.out.println(service.getConsumerByProductId(4L).toString());
        System.out.println(service.getConsumerByProductId(5L).toString());
        System.out.println(service.getConsumerByProductId(6L).toString());
    }
}
