package com.xzsd.pc.music.controller;

import com.neusoft.core.exception.ScServerException;
import com.xzsd.pc.music.entity.MusicInfo;
import com.xzsd.pc.music.service.MusicService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("music")
public class MusicController {

    private static final Logger logger = LoggerFactory.getLogger(MusicController.class);

    @Autowired
    private MusicService musicService;

    /**
     * 上传音乐
     * wumaoxing
     * 2020-10-16 22:05
     */
    @PostMapping("/addMusic")
    public String addMusic(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = null;
        //对文件的全名进行截取
        int begin = file.getOriginalFilename().indexOf(".");
        int last = file.getOriginalFilename().length();
        //获得文件后缀名
        String a = file.getOriginalFilename().substring(begin, last);
        MusicInfo musicInfo = new MusicInfo();
        String filePath = null;
        if(a.endsWith(".mp3")){
            //以时间戳和两位随机数作为文件名
            fileName = StringUtil.getCommonCode(2)+".mp3";
            musicInfo.setMusicUrl("/pc/static/music/"+fileName);
            filePath = "F:/毕业设计/idea/douyin/sc-provider/sc-xzsd-pc/src/main/resources/static/music/";
//          filePath = "C:/Users/Administrator/Desktop/douyin/sc-provider/sc-xzsd-pc/src/main/resources/static/music/";
            musicService.addMusic(musicInfo);
        }
        System.out.println(fileName);
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return "上传失败！";
    }

    /**
     * 获取音乐列表
     * wumaoxing
     * 2020-10-16 22:21
     */
    @PostMapping("listMusics")
    public AppResponse listMusics(){
        try {
            return musicService.listMusics();
        } catch (Exception e) {
            logger.error("音乐获取异常", e);
            throw new ScServerException("查询错误，请重试");
        }
    }
}
