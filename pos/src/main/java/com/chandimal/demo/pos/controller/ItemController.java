package com.chandimal.demo.pos.controller;


import com.chandimal.demo.pos.dto.request.ItemSaveDTO;
import com.chandimal.demo.pos.dto.response.ItemGetResponseDTO;
import com.chandimal.demo.pos.service.ItemService;
import com.chandimal.demo.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

//    @PostMapping(
//            path = "/save"
//    )
//    public String saveItem(@RequestBody ItemSaveDTO itemSaveDTO){
//        String saved = itemService.saveItem(itemSaveDTO);
//        return saved;
//
//    }

    //using Standard response mechanism
    @PostMapping(
            path = "/save"
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveDTO itemSaveDTO){
        String saved = itemService.saveItem(itemSaveDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",saved),
                HttpStatus.CREATED
        );
        return response;

    }

    @GetMapping(
            path = "/get-by-item-name",
            params = "name"

    )
    public List<ItemGetResponseDTO> getItemByNameAndState(@RequestParam(value = "name") String itemName){

        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemGetResponseDTOS;
    }

    @GetMapping(
            path = "/get-by-item-name-by-mapstruct",
            params = "name"

    )
    public List<ItemGetResponseDTO> getItemByNameAndStateByMapstruct(@RequestParam(value = "name") String itemName){

        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByNameAndStatusByMapstruct(itemName);
        return itemGetResponseDTOS;
    }


}
