package com.winnie.filemanagerjava.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 上传结果
 * @author: winnie
 * @date: 2020年10月11日
 */
@Data
@ApiModel("上传结果")
public class FileUploadResDTO {

    @ApiModelProperty("文件单号")
    private String number;

    @ApiModelProperty("归档日期")
    private Long date;

    @ApiModelProperty("文件归档地址")
    private String filePath;
}
