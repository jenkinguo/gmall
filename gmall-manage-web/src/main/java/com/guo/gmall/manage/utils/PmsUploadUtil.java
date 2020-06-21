package com.guo.gmall.manage.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-06-13 17:20
 **/
public class PmsUploadUtil {

    private static final String FASTFDS_PATH = PmsUploadUtil.class.getResource("/").getPath() + "/tracker.conf";

    static {
        try {
            ClientGlobal.init(FASTFDS_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static String uploadImage(MultipartFile multipartFile) {
        StringBuffer url = new StringBuffer("http://192.168.18.10");
        try {
            byte[] bytes = multipartFile.getBytes();

            String org_name = multipartFile.getOriginalFilename();
            String filetype = org_name.substring(org_name.lastIndexOf(".") + 1);

            TrackerServer server = new TrackerClient().getConnection();
            StorageClient storageClient = new StorageClient(server, null);
            String[] uploadFiles = storageClient.upload_file(bytes, filetype, null);
            for (String uploadFile : uploadFiles) {
                url.append(File.separator + uploadFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url.toString();
    }

}
