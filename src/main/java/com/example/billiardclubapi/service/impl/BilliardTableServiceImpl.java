package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.BilliardTable;
import com.example.billiardclubapi.exception.BilliardTableNotExistsException;
import com.example.billiardclubapi.repository.BilliardTableRepository;
import com.example.billiardclubapi.service.BilliardTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.billiardclubapi.util.ExceptionMessages.BILLIARD_TABLE_NOT_EXISTS;

@Service
@RequiredArgsConstructor
public class BilliardTableServiceImpl implements BilliardTableService {
    private final BilliardTableRepository billiardTableRepository;

    @Override
    public BilliardTable getById(Long id) {
        return getOrThrow(id);
    }

    @Override
    public List<BilliardTable> getAll() {
        return billiardTableRepository.findAll();
    }

    @Transactional
    @Override
    public BilliardTable save(BilliardTable billiardTable) {
        return billiardTableRepository.save(billiardTable);
    }

    @Transactional
    @Override
    public BilliardTable update(BilliardTable billiardTable) {
        getOrThrow(billiardTable.getId());
        return billiardTableRepository.save(billiardTable);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        getOrThrow(id);
        billiardTableRepository.deleteById(id);
    }

    @Override
    public String getImagePath(Long id) {
        return getOrThrow(id).getImagePath();
    }

    private BilliardTable getOrThrow(Long id) {
        return billiardTableRepository.findById(id)
                .orElseThrow(() -> new BilliardTableNotExistsException(String.format(BILLIARD_TABLE_NOT_EXISTS, id)));
    }
}