package com.huiminpay.merchant.service;

import com.huiminpay.merchant.api.MerchantService;
import com.huiminpay.merchant.dto.MerchantDTO;
import com.huiminpay.merchant.entity.Merchant;
import com.huiminpay.merchant.mapper.MerchantMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户：hahao
 * 日期：2023/7/6
 * 时间：19:31
 * 类名：MerchantServiceImpl
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantMapper merchantMapper;
    @Override
    public MerchantDTO selectMerchantById(Long id) {
        MerchantDTO merchantDTO = new MerchantDTO();
        Merchant merchant = merchantMapper.selectById(id);
        BeanUtils.copyProperties(merchant, merchantDTO);
        return merchantDTO;
    }

}
