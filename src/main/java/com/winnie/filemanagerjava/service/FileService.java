package com.winnie.filemanagerjava.service;

import com.winnie.filemanagerjava.dto.FileUploadResDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 文件管理
 * @author: winnie
 * @date: 2020年10月11日
 */
public interface FileService {
    /**
     * 文件上传基础服务
     */
    FileUploadResDTO uploadFile(MultipartFile multipartFile, String number, Long date);
}
