package com.example.files.services.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.example.files.configs.properties.AmazonS3Properties;
import com.example.files.dtos.FileInfoDTO;
import com.example.files.services.AbstractS3WrapperService;
import com.example.files.services.StorageService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StorageServiceImpl extends AbstractS3WrapperService implements StorageService {

    public StorageServiceImpl(AmazonS3 client,
                              AmazonS3Properties properties) {
        super(client, properties);
    }

    @Override
    public Mono<FileInfoDTO> retrieveAccessibleFile(String s3Id) {
        var accessibleURL = getUrlOfFile(s3Id);
        return Mono.just(new FileInfoDTO(s3Id, accessibleURL));
    }
}
