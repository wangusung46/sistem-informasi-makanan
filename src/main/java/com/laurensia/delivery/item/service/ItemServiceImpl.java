package com.laurensia.delivery.item.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.item.model.Item;
import com.laurensia.delivery.item.repository.ItemRepository;
import com.laurensia.delivery.item.request.ItemIdRequest;
import com.laurensia.delivery.item.request.ItemSaveRequest;
import com.laurensia.delivery.item.response.ItemDetailResponse;
import com.laurensia.delivery.item.response.ItemSaveResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public BaseResponse<List<ItemDetailResponse>> getItems() throws JsonProcessingException {
        BaseResponse<List<ItemDetailResponse>> responses = new BaseResponse<>();
        List<ItemDetailResponse> detailResponses = new ArrayList<>();
        List<Item> items = itemRepository.findAll();
        if (items != null) {
            for (Item item : items) {
                if (item.getActive()) {
                    ItemDetailResponse detailResponse = new ItemDetailResponse();

                    detailResponse.setActive(item.getActive());
                    detailResponse.setId(item.getId());
                    detailResponse.setName(item.getName());
                    detailResponse.setPrice(item.getPrice());
                    detailResponse.setStock(item.getStock());
                    detailResponses.add(detailResponse);
                }
            }
            responses.setStatus(true);
            responses.setPayload(detailResponses);
        } else {
            responses.setStatus(false);
            responses.setPayload(detailResponses);
        }
        return responses;
    }

    @Override
    public BaseResponse<ItemSaveResponse> saveItem(ItemSaveRequest request) {
        BaseResponse<ItemSaveResponse> response = new BaseResponse<>();
        ItemSaveResponse detailResponse = new ItemSaveResponse();
        Item item = new Item();
        item.setActive(Boolean.TRUE);
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        item.setStock(request.getStock());

        detailResponse.setActive(Boolean.TRUE);
        detailResponse.setName(request.getName());
        detailResponse.setPrice(request.getPrice());
        detailResponse.setStock(request.getStock());
        itemRepository.save(item);
        response.setStatus(true);
        response.setPayload(detailResponse);
        return response;
    }

    @Override
    public BaseResponse<ItemDetailResponse> deleteItem(ItemIdRequest request) {
        BaseResponse<ItemDetailResponse> response = new BaseResponse<>();
        ItemDetailResponse detailResponse = new ItemDetailResponse();
        Optional<Item> optional = itemRepository.findById(request.getId());
        if (optional != null) {
            if (optional.get().getActive()) {
                Item item = new Item();
                item.setActive(Boolean.FALSE);
                item.setId(optional.get().getId());
                item.setName(optional.get().getName());
                item.setPrice(optional.get().getPrice());
                item.setStock(optional.get().getStock());
                itemRepository.save(item);

                detailResponse.setActive(optional.get().getActive());
                detailResponse.setId(optional.get().getId());
                detailResponse.setName(optional.get().getName());
                detailResponse.setPrice(optional.get().getPrice());
                detailResponse.setStock(optional.get().getStock());

            }
            response.setStatus(true);
            response.setPayload(detailResponse);
        } else {
            response.setStatus(false);
        }
        return response;
    }

    @Override
    public BaseResponse<ItemDetailResponse> getItem(Long request) {
        BaseResponse<ItemDetailResponse> response = new BaseResponse<>();
        ItemDetailResponse detailResponse = new ItemDetailResponse();
        Optional<Item> optional = itemRepository.findById(request);
        if (optional != null) {
            if (optional.get().getActive()) {

                detailResponse.setActive(optional.get().getActive());
                detailResponse.setId(optional.get().getId());
                detailResponse.setName(optional.get().getName());
                detailResponse.setPrice(optional.get().getPrice());
                detailResponse.setStock(optional.get().getStock());

            }
            response.setStatus(true);
            response.setPayload(detailResponse);
        } else {
            response.setStatus(false);
        }
        return response;
    }

}
