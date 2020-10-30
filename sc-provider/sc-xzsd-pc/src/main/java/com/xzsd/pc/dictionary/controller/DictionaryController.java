package com.xzsd.pc.dictionary.controller;

import com.xzsd.pc.dictionary.service.DictionaryService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);

    @Resource
    private DictionaryService dictionaryService;

    /**
     * 查询站点所在位置
     * wumaoxing
     * 2020-08-25 20:22
     */
    @RequestMapping("querySiteLocalClassify")
    public AppResponse querySiteLocalClassify(String lastClassifyId) {
        try {
            return dictionaryService.querySiteLocalClassify(lastClassifyId);
        } catch (Exception e) {
            logger.error("查询站点所在位置异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}

