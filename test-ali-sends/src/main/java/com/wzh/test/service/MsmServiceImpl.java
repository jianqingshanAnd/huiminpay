package com.wzh.test.service;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author Eric
 * @create  2022-05-22 15:09
 */
@Service
public class MsmServiceImpl implements MsmService{
    /**
     * 发送验证码
     * @param param     验证码
     * @param phone     手机号
     * @return
     */
    @Override
    public boolean send(Map<String, Object> param, String phone) {

        if(StringUtils.isEmpty(phone)) return false;

        //default 地域节点，默认就好  后面是 阿里云的 id和秘钥（这里记得去阿里云复制自己的id和秘钥哦）
        DefaultProfile profile = DefaultProfile.getProfile("default", "id", "私钥");
        IAcsClient client = new DefaultAcsClient(profile);

        //这里不能修改
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

//        request.putQueryParameter("PhoneNumbers", phone);                    //手机号
//        request.putQueryParameter("SignName", "阿里云短信测试");    //申请阿里云 签名名称（暂时用阿里云测试的，自己还不能注册签名）
//        request.putQueryParameter("TemplateCode", "模板id"); //申请阿里云 模板code（用的也是阿里云测试的）
//        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));

        request.putQueryParameter("PhoneNumbers", phone);                    //手机号
        request.putQueryParameter("SignName", "签名");    //申请阿里云 签名名称（暂时用阿里云测试的，自己还不能注册签名）
        request.putQueryParameter("TemplateCode", "模板id"); //申请阿里云 模板code（用的也是阿里云测试的）
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

