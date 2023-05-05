package com.example.files.services;

import com.amazonaws.services.s3.AmazonS3;
import com.example.files.configs.properties.AmazonS3Properties;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractS3WrapperService {

    protected final AmazonS3 client;
    protected final AmazonS3Properties properties;

    protected String getUrlOfFile(String s3Id) {
        return String.valueOf(client.getUrl(properties.getBucketName(), s3Id));
    }

}
