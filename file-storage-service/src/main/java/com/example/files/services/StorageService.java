package com.example.files.services;

import com.example.files.dtos.FileInfoDTO;
import reactor.core.publisher.Mono;

public interface StorageService {

    Mono<FileInfoDTO> retrieveAccessibleFile(String s3Id);
}
