package com.aiit.controller;

import com.aiit.entity.UserList;
import com.aiit.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/face")
public class FaceController {
    @Autowired
    UserService userService;

    @RequestMapping("/getAccessToken")
    @CrossOrigin
    public String getAccessToken(){
        String url = "https://aip.baidubce.com/oauth/2.0/token";
        // 请求头设置,x-www-form-urlencoded格式的数据
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //第一次请求，获取accessToken
        //提交参数设置
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");
        map.add("client_id", "smXtZZWziqKGG1aLegH9j4XH");
        map.add("client_secret","bH6Xa3KG5ZWB3uNkGVIWK0oc1oOqVXgm");

        // 组装请求体
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        // 发送post请求，并打印结果，以String类型接收响应结果JSON字符串
        String result = restTemplate.postForObject(url, request, String.class);
        JSONObject res = JSON.parseObject(result);
        String access_token = res.getString("access_token");
        return access_token;
    }
    @RequestMapping("/ImgToUser")
    @CrossOrigin
    public Map<String,Object> ImgToUser(@RequestParam(name = "access_token")String access_token,@RequestParam(name = "image")String image){
        Map<String,Object> dataMap = new HashMap<String,Object>();
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match?access_token=" + access_token;
        // 请求头设置,x-www-form-urlencoded格式的数据
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //第一次请求，获取accessToken
        //提交参数设置
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("image", image);
        map.add("image_type", "BASE64");
        map.add("group_id_list", "user01");

        // 组装请求体
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        // 发送post请求，并打印结果，以String类型接收响应结果JSON字符串
        String result = restTemplate.postForObject(url, request, String.class);
        JSONObject res = JSON.parseObject(result);
        String face_token = res.getString("face_token");
        String user_list = res.getString("user_list");
        List<UserList> userLists = JSON.parseArray(user_list,UserList.class);
        dataMap.put("UserList",userLists);
        dataMap.put("face_token",face_token);
        return dataMap;
    }
    @RequestMapping("/selectUser")
    @CrossOrigin
    public String selectUser(@RequestParam(name = "userId")String userId){
        return userService.SelectUser(userId);
    }
}
