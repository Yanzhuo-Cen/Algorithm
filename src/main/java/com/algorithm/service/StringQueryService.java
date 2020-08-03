package com.algorithm.service;

import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StringQueryService {

    float getSimilarityRatio(String str1, String str2);

    JSONArray fuzzySearch(String name, JSONArray jsonArray, String indexes);

}
