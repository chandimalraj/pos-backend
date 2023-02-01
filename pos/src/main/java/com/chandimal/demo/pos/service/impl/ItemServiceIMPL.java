package com.chandimal.demo.pos.service.impl;

import com.chandimal.demo.pos.dto.request.ItemSaveDTO;
import com.chandimal.demo.pos.dto.response.ItemGetResponseDTO;
import com.chandimal.demo.pos.entity.Item;
import com.chandimal.demo.pos.repo.ItemRepo;
import com.chandimal.demo.pos.service.ItemService;
import com.chandimal.demo.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveDTO itemSaveDTO) {

//        Item item = new Item(
//                1,
//                itemSaveDTO.getItemName(),
//                itemSaveDTO.getMeasuringUnitType(),
//                itemSaveDTO.getBalanceQuantity(),
//                itemSaveDTO.getSupplierPrice(),
//                itemSaveDTO.getSellingPrice(),
//                true
//
//        );
//
//
//        itemRepo.save(item);
       Item item = modelMapper.map(itemSaveDTO,Item.class);
       itemRepo.save(item);
        return itemSaveDTO.getItemName()+ " saved";

    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {

        boolean status = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveEquals(itemName,status);


        if(items.size()>0){
            List<ItemGetResponseDTO> getResponseDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return getResponseDTOS;

        }else{

            throw  new RuntimeException("Not Found");

        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName) {
        boolean status = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveEquals(itemName,status);

        if(items.size()>0){
            List<ItemGetResponseDTO> getResponseDTOS = itemMapper.entityListToDtoList(items);
            return getResponseDTOS;

        }else{

            throw  new RuntimeException("Not Found");

        }
    }


}
