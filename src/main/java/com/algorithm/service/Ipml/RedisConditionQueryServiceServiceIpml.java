package com.algorithm.service.Ipml;


import com.algorithm.service.RedisConditionQueryService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RedisConditionQueryServiceServiceIpml implements RedisConditionQueryService {

    @Override
    public JSONArray returnJSONArray(String input, String key, String value) {
        JSONArray mm = JSONArray.fromObject(input);
        JSONArray result = new JSONArray();
        int j=0;
        for(int i=0; i<mm.size(); i++){
            if(mm.getJSONObject(i).getString(key).equals(value)){
                result.add(j,mm.getJSONObject(i));
                j++;
            }
        }
        return result;
    }

    @Override
    public JSONObject returnJSONObject(String input, String key, String value) {
        JSONArray mm = JSONArray.fromObject(input);
        JSONObject result = new JSONObject();
        for(int i=0; i<mm.size(); i++){
            if(mm.getJSONObject(i).getString(key).equals(value)){
                result = mm.getJSONObject(i);
                break;
            }
        }
        return result;
    }
}
