package com.acme.delivery.converter;


import com.acme.delivery.domain.Store;
import com.acme.delivery.transfer.StoreDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class StoreConverter {

	private final ModelMapper mapper;

	public Store dtoToEntity(StoreDTO storeDto) {
		return mapper.map(storeDto, Store.class);
	}

	public StoreDTO entityToDto(Store store) {
		return mapper.map(store, StoreDTO.class);
	}

	public List<StoreDTO> entityToDto(List<Store> stores) {
		return stores.stream().map(this::entityToDto).toList();
	}

}
