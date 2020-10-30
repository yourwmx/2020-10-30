package com.xzsd.pc.dictionary.service;

import com.xzsd.pc.dictionary.dao.DictionaryDao;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DictionaryService {

    @Resource
    private DictionaryDao dictionaryDao;

    /**
     * 查询站点所在位置
     * wumaoxing
     * 2020-08-25 8:57
     */
    public AppResponse querySiteLocalClassify(String lastClassifyId) {
        return AppResponse.success("查询成功！",dictionaryDao.querySiteLocalClassify(lastClassifyId));
    }


}

