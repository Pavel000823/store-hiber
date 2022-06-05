package com.geek.app.dao;


import com.geek.app.MyAppBdSessionFactory;
import com.geek.app.model.Consumer;
import com.geek.app.model.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PurchasesDao {

    private final MyAppBdSessionFactory factory;

    @Autowired
    public PurchasesDao(MyAppBdSessionFactory myAppBdSessionFactory) {
        factory = myAppBdSessionFactory;
    }


    public List<Product> findPurchasedProductsByConsumerId(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Consumer consumer = session.get(Consumer.class, id);
            List<Product> products = consumer.getProductList();
            System.out.println(products.size());
            session.getTransaction().commit();
            return products;
        }
    }

    public List<Consumer> findConsumersBoughtProductById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            List<Consumer> consumers = product.getConsumers();
            System.out.println(consumers.size());
            session.getTransaction().commit();
            return consumers;
        }
    }


}
