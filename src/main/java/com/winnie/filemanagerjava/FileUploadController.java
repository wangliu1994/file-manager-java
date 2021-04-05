package com.winnie.filemanagerjava;

import com.winnie.filemanagerjava.common.Result;
import com.winnie.filemanagerjava.dto.FileUploadResDTO;
import com.winnie.filemanagerjava.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Description: 文件上传
 * @author: winnie
 * @date: 2020年10月08日
 */
@RestController
@RequestMapping("/file/v1")
@Api(tags = "文件上传下载")
public class FileUploadController {
    @Resource
    private FileService fileService;

    /**
     * 上传图片
     */
    @PostMapping({"/upload"})
    @ApiOperation("上传")
    public Result<FileUploadResDTO> upload(@RequestParam("file") MultipartFile file,
                                           @RequestParam("type") Integer type,
                                           @RequestParam("number") String number,
                                           @RequestParam("date") Long date) {
        return Result.success(fileService.uploadFile(file, type, number, date));
    }


    @GetMapping("/test")
    @ApiOperation("测试服务器连接")
    public Result<Boolean> testServer() {
        return Result.success(true);
    }
}
