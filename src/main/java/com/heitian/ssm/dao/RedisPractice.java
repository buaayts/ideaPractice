package com.heitian.ssm.dao;

import com.alibaba.fastjson.JSONObject;
import com.heitian.ssm.po.ItemsCustomer;
import redis.clients.jedis.Jedis;

import javax.json.JsonObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * @Description: Created by yetaoshan on 18/2/21.
 * @Modified By:
 */

public class RedisPractice {
    public static void main(String[] args) {
        ItemsCustomer itemsCustomer = new ItemsCustomer();
//        SimpleDateFormat former = new SimpleDateFormat("yyyy-MM-DD");
        itemsCustomer.setId(123);
        itemsCustomer.setCreatetime(Calendar.getInstance().getTime());
        String json = JSONObject.toJSONString(itemsCustomer);
        HashMap map = new HashMap();
        map.put("json",json);
        Jedis jedis = new Jedis("localhost",6379);
//        jedis.set("yts","fucker");
//        System.out.println(jedis.get("yts"));
        jedis.hmset("tryHash",map);
        System.out.println(jedis.hgetAll("tryHash"));
    }
}
