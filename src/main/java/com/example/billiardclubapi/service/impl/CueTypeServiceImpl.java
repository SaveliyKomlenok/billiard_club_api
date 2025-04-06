package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.CueType;
import com.example.billiardclubapi.exception.CueTypeNotExistsException;
import com.example.billiardclubapi.repository.CueTypeRepository;
import com.example.billiardclubapi.service.CueTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.billiardclubapi.util.ExceptionMessages.CUE_TYPE_NOT_EXISTS;

@Service
@RequiredArgsConstructor
public class CueTypeServiceImpl implements CueTypeService {
    private final CueTypeRepository cueTypeRepository;

    @Override
    public CueType getById(Long id) {
        return getOrThrow(id);
    }

    @Override
    public List<CueType> getAll() {
        return cueTypeRepository.findAll();
    }

    @Override
    public CueType save(CueType cueType) {
        return cueTypeRepository.save(cueType);
    }

    @Override
    public CueType update(CueType cueType) {
        getOrThrow(cueType.getId());
        return cueTypeRepository.save(cueType);
    }

    @Override
    public void delete(Long id) {
        getOrThrow(id);
        cueTypeRepository.deleteById(id);
    }

    private CueType getOrThrow(Long id) {
        return cueTypeRepository.findById(id)
                .orElseThrow(() -> new CueTypeNotExistsException(String.format(CUE_TYPE_NOT_EXISTS, id)));
    }
}