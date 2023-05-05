package com.example.files.handlers;

import com.example.files.dtos.FileInfoDTO;
import com.example.files.services.StorageService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record FileHandler(StorageService storageService) {

    public Mono<ServerResponse> get(ServerRequest serverRequest) {
        var s3Id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(storageService.retrieveAccessibleFile(s3Id), FileInfoDTO.class);
    }
}
