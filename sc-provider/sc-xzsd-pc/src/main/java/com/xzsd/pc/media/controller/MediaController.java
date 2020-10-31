package com.xzsd.pc.media.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.media.entity.MediaInfo;
import com.xzsd.pc.media.service.MediaService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("media")
public class MediaController {

    private static final Logger logger = LoggerFactory.getLogger(MediaController.class);

    @Resource
    private MediaService mediaService;

    /**
     * 新增图片
     */
    @PostMapping("/addFile")
    public String addFile(@Param("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = null;
        //对文件的全名进行截取
        int begin = file.getOriginalFilename().indexOf(".");
        int last = file.getOriginalFilename().length();
        //获得文件后缀名
        String a = file.getOriginalFilename().substring(begin, last);
        MediaInfo mediaInfo = new MediaInfo();
        String filePath = null;
        String mediaId = StringUtil.getCommonCode(2);
        if (a.endsWith(".jpg")) {
            //以时间戳和两位随机数作为文件名
            fileName = mediaId + ".jpg";
        } else if (a.endsWith(".png")) {
            //以时间戳和两位随机数作为文件名
            fileName = mediaId + ".png";
        }
        mediaInfo.setMediaId(mediaId);
        mediaInfo.setMediaUrl("/pc/static/media/" + fileName);
        filePath = "F:/毕业设计/idea/douyin/sc-provider/sc-xzsd-pc/src/main/resources/static/media/";
//          filePath = "C:/Users/Administrator/Desktop/douyin/sc-provider/sc-xzsd-pc/src/main/resources/static/media/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            return mediaInfo.getMediaUrl();
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return "上传失败！";
    }

    /**
     * 新增文件
     */
    @PostMapping("/addMedia")
    public String addMedia(MediaInfo mediaInfo) {
        MultipartFile file = mediaInfo.getFile();
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = null;
        //对文件的全名进行截取
        int begin = file.getOriginalFilename().indexOf(".");
        int last = file.getOriginalFilename().length();
        //获得文件后缀名
        String a = file.getOriginalFilename().substring(begin, last);
        //获取当前登录人编号
        String userId = SecurityUtils.getCurrentUserId();
        mediaInfo.setUserId(userId);
        mediaInfo.setCreateBy(userId);
        String filePath = null;
        String mediaId = StringUtil.getCommonCode(2);
        if (a.endsWith(".mp4")) {
            //以时间戳和两位随机数作为文件名
            fileName = mediaId + ".mp4";
        } else if (a.endsWith(".jpg")) {
            //以时间戳和两位随机数作为文件名
            fileName = mediaId + ".jpg";
        } else if (a.endsWith(".png")) {
            //以时间戳和两位随机数作为文件名
            fileName = mediaId + ".png";
        }
        mediaInfo.setMediaId(mediaId);
        mediaInfo.setMediaUrl("/pc/static/media/" + fileName);
//        filePath = "F:/毕业设计/idea/douyin/sc-provider/sc-xzsd-pc/src/main/resources/static/media/";
          filePath = "C:/Users/Administrator/Desktop/douyin/sc-provider/sc-xzsd-pc/src/main/resources/static/media/";
        //若不是缩略图，则写入media表中
        if("0".compareTo(mediaInfo.getIsMediaThumb()) == 0){
            mediaService.addMedia(mediaInfo);
        }
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            return mediaInfo.getMediaUrl();
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return "上传失败！";
    }

    /**
     * 获取文件列表
     * wumaoxing
     * 2020-10-15 21:59
     */
    @RequestMapping("listMedias")
    public AppResponse listMedias(MediaInfo mediaInfo) {
        try {
            return mediaService.listMedias(mediaInfo);
        } catch (Exception e) {
            logger.error("文件获取异常", e);
            throw new ScServerException("查询错误，请重试");
        }
    }

    /**
     * 删除文件
     * wumaoxing
     * 2020-10-24 15:57
     */
    @PostMapping("deleteMedia")
    public AppResponse deleteMedia(String mediaId) {
        try {
            //获取用户id
            String updateUserId = SecurityUtils.getCurrentUserId();
            return mediaService.deleteMedia(mediaId, updateUserId);
        } catch (Exception e) {
            logger.error("文件删除异常", e);
            throw new ScServerException("删除错误，请重试");
        }
    }
}
