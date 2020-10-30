package com.xzsd.pc.dictionary.dao;

import com.xzsd.pc.dictionary.entity.DictionaryInfo;

import java.util.List;

public interface DictionaryDao {
    /**
     * 查询站点所在位置
     * wumaoxing
     * 2020-08-25 20:29
     */
    List<DictionaryInfo> querySiteLocalClassify(String lastClassifyId);
}
