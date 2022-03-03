package com.laurensia.delivery.item.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.item.request.ItemIdRequest;
import com.laurensia.delivery.item.request.ItemSaveRequest;
import com.laurensia.delivery.item.response.ItemDetailResponse;
import com.laurensia.delivery.item.response.ItemSaveResponse;
import java.util.List;

/**
 * @author Khanza
 *
 */
public interface ItemService {

    public BaseResponse<List<ItemDetailResponse>> getItems() throws JsonProcessingException;

    public BaseResponse<ItemSaveResponse> saveItem(ItemSaveRequest request);

    public BaseResponse<ItemDetailResponse> deleteItem(ItemIdRequest request);

    public BaseResponse<ItemDetailResponse> getItem(Long request);

}
