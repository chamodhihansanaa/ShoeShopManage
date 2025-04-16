package lk.ijse.helloshoe.service;


import lk.ijse.helloshoe.dto.CustomDTO;
import lk.ijse.helloshoe.dto.SaleDTO;
import lk.ijse.helloshoe.dto.SaleDetailsDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

public interface SaleService {
    void placeOrder(@RequestBody SaleDTO dto);

    ArrayList<SaleDTO> LoadOrders();

    ArrayList<SaleDetailsDTO> LoadOrderDetails();

    @ResponseBody
    CustomDTO OrderIdGenerate();

    @ResponseBody
    CustomDTO getSumOrders();

    Double getTotalSales();

    Double getTotalProfit();

    Object[] getMostSoldItem();

    String getBase64EncodedImageOfMostSoldItem();

    int getMostSoldItemQuantity();

    void deleteOrder(String orderNo);

    void refundOrder(String orderNo);
}


