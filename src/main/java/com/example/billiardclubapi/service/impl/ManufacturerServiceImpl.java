package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.Manufacturer;
import com.example.billiardclubapi.exception.ManufacturerNotExistsException;
import com.example.billiardclubapi.repository.ManufacturerRepository;
import com.example.billiardclubapi.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.billiardclubapi.util.ExceptionMessages.MANUFACTURER_NOT_EXISTS;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer getById(Long id) {
        return getOrThrow(id);
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    @Transactional
    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    @Transactional
    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        getOrThrow(manufacturer.getId());
        return manufacturerRepository.save(manufacturer);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        getOrThrow(id);
        manufacturerRepository.deleteById(id);
    }

    private Manufacturer getOrThrow(Long id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new ManufacturerNotExistsException(String.format(MANUFACTURER_NOT_EXISTS, id)));
    }
}