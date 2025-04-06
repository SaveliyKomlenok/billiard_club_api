package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.BilliardTableType;
import com.example.billiardclubapi.enumiration.BilliardTableTypeNotExistsException;
import com.example.billiardclubapi.repository.BilliardTableTypeRepository;
import com.example.billiardclubapi.service.BilliardTableTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.billiardclubapi.util.ExceptionMessages.BILLIARD_TABLE_TYPE_NOT_EXISTS;

@Service
@RequiredArgsConstructor
public class BilliardTableTypeServiceImpl implements BilliardTableTypeService {
    private final BilliardTableTypeRepository billiardTableTypeRepository;

    @Override
    public BilliardTableType getById(Long id) {
        return getOrThrow(id);
    }

    @Override
    public List<BilliardTableType> getAll() {
        return billiardTableTypeRepository.findAll();
    }

    @Transactional
    @Override
    public BilliardTableType save(BilliardTableType billiardTableType) {
        return billiardTableTypeRepository.save(billiardTableType);
    }

    @Transactional
    @Override
    public BilliardTableType update(BilliardTableType billiardTableType) {
        getOrThrow(billiardTableType.getId());
        return billiardTableTypeRepository.save(billiardTableType);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        getOrThrow(id);
        billiardTableTypeRepository.deleteById(id);
    }

    private BilliardTableType getOrThrow(Long id) {
        return billiardTableTypeRepository.findById(id)
                .orElseThrow(() -> new BilliardTableTypeNotExistsException(String.format(BILLIARD_TABLE_TYPE_NOT_EXISTS, id)));
    }
}
