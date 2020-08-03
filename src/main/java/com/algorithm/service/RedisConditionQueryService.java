package com.algorithm.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisConditionQueryService {

    JSONArray returnJSONArray(String input, String key, String value);

    JSONObject returnJSONObject(String input, String key, String value);
}
