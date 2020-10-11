package com.winnie.filemanagerjava.service;

import com.winnie.filemanagerjava.dto.FileUploadResDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author: winnie
 * @date: 2020年10月11日
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @Value("${file.base.path}")
    private String fileBasePath;

    @Override
    public FileUploadResDTO uploadFile(MultipartFile multipartFile, String number, Long date) {
        FileUploadResDTO fileUploadResDTO = new FileUploadResDTO();

        //存储路径
        Date dateTime = new Date(date);
        String path1 = new SimpleDateFormat("yyyy", Locale.getDefault()).format(dateTime);
        String path2 = new SimpleDateFormat("yyyy-MM", Locale.getDefault()).format(dateTime);
        String path3 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(dateTime);


        String orgFileName = multipartFile.getOriginalFilename();
        String orgFileType = orgFileName.substring(orgFileName.lastIndexOf("."));
        if(orgFileType.length() <= 0){
            throw new RuntimeException("文件类型不存在");
        }
        File fileDir = new File(fileBasePath
                .concat("面单管理\\\\")
                .concat(File.separator)
                .concat(path1)
                .concat(File.separator)
                .concat(path2)
                .concat(File.separator)
                .concat(path3)
                .concat(File.separator));
        //判断文件夹是否存在
        if(!fileDir.exists()){
            //不存在时，创建文件夹
            fileDir.mkdirs();
        }

        File file = new File(fileDir, number.concat(orgFileType));
        try {
            //保存文件
            //使用此方法保存必须要绝对路径且文件夹必须已存在
            multipartFile.transferTo(file);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException("文件转换异常");
        }

        fileUploadResDTO.setNumber(number);
        fileUploadResDTO.setDate(date);
        fileUploadResDTO.setFilePath(file.getAbsolutePath());

        return fileUploadResDTO;
    }
}
