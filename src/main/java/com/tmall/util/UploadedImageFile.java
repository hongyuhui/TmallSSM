package com.tmall.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by OovEver on 2017/11/9.
 */
public class UploadedImageFile {
    MultipartFile image;
    public MultipartFile getImage() {
        return image;
    }
    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
