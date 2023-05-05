package com.example.files;

import com.example.files.configs.routes.ImageRouter;
import com.example.files.dtos.FileInfoDTO;
import com.example.files.handlers.FileHandler;
import com.example.files.services.StorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ImageEndpointTest {

    private WebTestClient webTestClient;
    private StorageService storageService;

    @BeforeEach
    void setUp() {
        storageService = mock(StorageService.class);

        var storageHandler = new FileHandler(storageService);
        var storageRoutes = new ImageRouter()
                .imageRoutes(storageHandler);

        webTestClient = WebTestClient.bindToRouterFunction(storageRoutes)
                .build();
    }

    @Test
    void should_ReturnOKAndFileInfo_When_GetImageByS3Id() {
        var s3Id = "dummy-4659832c-eebc-40a8-b77d-c8f9a9fe6c98";
        var url = "https://bucket-name.s3.eu-west-1.amazonaws.com/dummy-4659832c-eebc-40a8-b77d-c8f9a9fe6c98.png";
        when(storageService.retrieveAccessibleFile(s3Id))
                .thenReturn(Mono.just(new FileInfoDTO(s3Id, url)));

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v1/images/" + s3Id)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.s3Id").isEqualTo(s3Id)
                .jsonPath("$.url").isEqualTo(url);
        ;
    }
}
