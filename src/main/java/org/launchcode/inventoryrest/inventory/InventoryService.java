package org.launchcode.inventoryrest.inventory;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class InventoryService {

    private static List<Item> items = new ArrayList<>();
    private static long idCounter = 0;

    static {
        items.add(new Item(++idCounter, "johndw","Cheese","5", new Date()));
        items.add(new Item(++idCounter, "johndw","Bacon","6", new Date()));
        items.add(new Item(++idCounter, "johndw","Coffee","7", new Date()));
    }

    public List<Item> findAll() {
        return items;
    }

    public Item save(Item item) {
        if(item.getId()==-1) {
            item.setId(++idCounter);
            items.add(item);
        } else {
            deleteById(item.getId());
            items.add(item);
        }
        return item;
    }

    public Item deleteById(long id) {
        Item item = findById(id);

        if(item==null) return null;

        if(items.remove(item)) {
            return item;
        }

        return null;
    }

    public Item findById(long id) {
        for(Item item:items) {
            if(item.getId() == id) {
                return item;
            }
        }

        return null;
    }

}
