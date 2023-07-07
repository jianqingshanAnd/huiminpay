package com.huiminpay.merchant.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户：hahao
 * 日期：2023/7/6
 * 时间：19:12
 * 类名：MerchantDTO
 */
@Data
public class MerchantDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String merchantName;

    private String merchantNo;

    private String merchantAddress;

    private String merchantType;

    private String businessLicensesImg;

    private String idCardFrontImg;

    private String idCardAfterImg;

    private String username;

    private String mobile;

    private String contactsAddress;

    private String auditStatus;

    private Long tenantId;


}
