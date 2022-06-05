package com.geek.app.services;

import com.geek.app.MyAppBdSessionFactory;
import com.geek.app.dao.PurchasesDao;
import com.geek.app.model.Consumer;
import com.geek.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasesService {

    private final PurchasesDao purchasesDao;


    @Autowired
    public PurchasesService (PurchasesDao purchasesDao){
        this.purchasesDao = purchasesDao;
    }


    public List<Product> getProductListByConsumerId(Long id){
        return purchasesDao.findPurchasedProductsByConsumerId(id);
    }

    public List<Consumer> getConsumerByProductId(Long id){
        return purchasesDao.findConsumersBoughtProductById(id);
    }
}
