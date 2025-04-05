package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    @SneakyThrows
    @Override
    public byte[] getImage(String imagePath) {
        return Files.readAllBytes(new File(imagePath).toPath());
    }
}
