package org.launchcode.inventoryrest.inventory;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class InventoryController {

    @Autowired
    private InventoryService ItemService;

    @GetMapping("/users/{username}/items")
    public List<Item> getAllItems(@PathVariable String username){
        return ItemService.findAll();
    }

    @GetMapping("/users/{username}/items/{id}")
    public Item getItem(@PathVariable String username, @PathVariable long id){
        return ItemService.findById(id);
    }

    @DeleteMapping("/users/{username}/items/{id}")
    public ResponseEntity<Void> deleteItem(
            @PathVariable String username, @PathVariable long id){

        Item item = ItemService.deleteById(id);

        if(item!=null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable String username,
                                           @PathVariable long id, @RequestBody Item item){

        Item itemUpdated = ItemService.save(item);

        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/items")
    public ResponseEntity<Void> createdItem(@PathVariable String username, @RequestBody Item item){

        Item createdItem = ItemService.save(item);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdItem.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}