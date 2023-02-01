package com.chandimal.demo.pos.service;


import com.chandimal.demo.pos.dto.request.ItemSaveDTO;
import com.chandimal.demo.pos.dto.response.ItemGetResponseDTO;

import java.util.List;


public interface ItemService {

   String saveItem(ItemSaveDTO itemSaveDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName);
}
