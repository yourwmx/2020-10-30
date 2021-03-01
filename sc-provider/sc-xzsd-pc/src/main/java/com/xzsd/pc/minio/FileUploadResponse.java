package com.xzsd.pc.minio;

/**
 * <h3>FileUploadResponse</h3>
 * <p>上传到minio的实体类</p>
 *
 * @author : CharLinHeng
 * @date : 2021-03-01 10:41
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadResponse {
    private String urlHttp;

    private String urlPath;
}
