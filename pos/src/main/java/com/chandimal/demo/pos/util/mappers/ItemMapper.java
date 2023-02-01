package com.chandimal.demo.pos.util.mappers;

import com.chandimal.demo.pos.dto.response.ItemGetResponseDTO;
import com.chandimal.demo.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ItemMapper {

    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);
}
