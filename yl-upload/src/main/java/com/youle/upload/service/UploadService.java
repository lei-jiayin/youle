package com.youle.upload.service;

import com.youle.common.enums.ExceptionEnums;
import com.youle.common.exception.YlException;
import com.youle.upload.config.UploadProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 上传
 * @author xw
 * @date 2019/5/31 14:32
 */
@Service
@Slf4j
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {

    @Autowired
    private UploadProperties prop;
    //private static final List<String> ALLOW_TYPES = Arrays.asList("image/jpeg","image/png","image/bmp");
    /**
     * 上传图片
     * @param file
     * @return
     */
    public String uploadImage(MultipartFile file) {
        try {
            // 校验文件
            String contentType = file.getContentType();
            if (!prop.getAllowTypes().contains(contentType)){
                throw new YlException(ExceptionEnums.INVALID_FILE_TYPE);
            }
            // 校验文件内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null){
                throw new YlException(ExceptionEnums.INVALID_FILE_TYPE);
            }
            // 准备目标路径
            File dest = new File(prop.getBaseUrl(),file.getOriginalFilename());
            //1. 保存文件
            file.transferTo(dest);
            //2. 返回路径 D:\IdeaProjects\youle\yl-upload\src\upload\1.jpg yl-upload/src/upload/1.jpg
            return "http://image.youle.com/" + file.getOriginalFilename();
        } catch (IOException e) {
            // 上传文件失败
            log.error("上传文件失败！",e);
            throw new YlException(ExceptionEnums.UPLOAD_FILE_ERROR);
        }
    }
}
