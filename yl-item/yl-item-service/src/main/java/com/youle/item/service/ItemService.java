package com.youle.item.service;

import com.youle.item.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author xw
 * @date 2019/5/29 10:13
 */
@Service
public class ItemService {
    public Item saveItem(Item item){
        int id = new Random().nextInt(100);
        item.setId(id);
        return  item;
    }
}
