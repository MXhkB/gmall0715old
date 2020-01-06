package com.atguigu.gmall.manage.controller;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class FileUploadController {

    //对于服务器ip讲 ：都应在应用程序中实现软编码
    @Value("${fileServer.url}")
    private String fileUrl;


    //springMVC文件上传
    @RequestMapping("fileUpload")
    public String FileUpload(MultipartFile file) throws IOException, MyException {
        String imgUrl =fileUrl;
        if (file != null) {
            String configFile = this.getClass().getResource("/tracker.conf").getFile();
            ClientGlobal.init(configFile);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageClient storageClient = new StorageClient(trackerServer, null);
            //得到文件名称
            String originalFilename = file.getOriginalFilename();//1000.jpg
            //设置文件的后缀名
            String extName = StringUtils.substringAfterLast(originalFilename,".");

            //String orginalFilename = "e://1000.jpg";

            String[] upload_file = storageClient.upload_file(file.getBytes(), extName, null);
            for (int i = 0; i < upload_file.length; i++) {
                String path = upload_file[i];
                //System.out.println("s = " + s);
                imgUrl+="/"+path;
                System.out.println(imgUrl);
            }

        }
        return imgUrl;
    }



}