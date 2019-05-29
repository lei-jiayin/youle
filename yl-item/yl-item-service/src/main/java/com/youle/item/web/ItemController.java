package com.youle.item.web;

import com.sun.deploy.panel.ITreeNode;
import com.youle.common.enums.ExceptionEnums;
import com.youle.common.exception.YlException;
import com.youle.item.pojo.Item;
import com.youle.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xw
 * @date 2019/5/29 10:16
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * rest风格的返回
     * @param item
     * @return
     */
    @PostMapping
    public ResponseEntity<Item> saveItem(Item item){
        //校验价格
        if (item.getPrice() == null){
            throw new YlException(ExceptionEnums.PRICE_CANNOT_BE_NULL);
        }

        Item item1 = itemService.saveItem(item);

        return ResponseEntity.status(HttpStatus.CREATED).body(item1);
    }
}
