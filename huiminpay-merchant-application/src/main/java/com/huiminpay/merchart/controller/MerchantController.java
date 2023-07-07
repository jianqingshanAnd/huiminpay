package com.huiminpay.merchart.controller;


import com.huiminpay.merchant.api.MerchantService;
import com.huiminpay.merchant.dto.MerchantDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户：hahao
 * 日期：2023/7/6
 * 时间：19:16
 * 类名：MerchantController
 */
@RestController
public class MerchantController {

    @Reference
    MerchantService merchantService;

    @GetMapping("/merchants/{id}")
    public MerchantDTO selectMerchantById(@PathVariable Long id){

        return merchantService.selectMerchantById(id);

    }
}
