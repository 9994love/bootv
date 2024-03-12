package org.example.controller;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import lombok.RequiredArgsConstructor;
import org.example.pojo.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class FileUploadController {

    @Value("${upload.local.dir}")
    private String uploadLocalUrl;

    @Value("${upload.cloud.dir}")
    private String uploadCloudUrl;
    @Value("${cos.bucketName}")
    private String bucketName;
    private final COSClient cosClient;
    @Value("${cos.url.prefix}")
    private String cosUrlPrefix;
    /**
     * 文件上传
     */
    @PostMapping("upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        //1.暂存本地
        String originFileName = file.getOriginalFilename();
        String fileName = UUID.randomUUID() + originFileName.substring(originFileName.indexOf('.'));
        String fullPathFileName = uploadLocalUrl + fileName;
        file.transferTo(new File(fullPathFileName));
        //2.读取本地
        File localFile = new File(fullPathFileName);
        //3.指定文件将要存放的存储桶
        //指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = uploadCloudUrl + fileName;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        cosClient.putObject(putObjectRequest);
        String accessUrl = cosUrlPrefix + key;
        return Result.success(accessUrl);
    }

    public static void main(String[] args) {

    }
}
