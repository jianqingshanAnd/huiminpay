package com.huiminpay.merchant.api;


import com.huiminpay.merchant.dto.MerchantDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface MerchantService {
    public MerchantDTO selectMerchantById(@PathVariable Long id);
}
