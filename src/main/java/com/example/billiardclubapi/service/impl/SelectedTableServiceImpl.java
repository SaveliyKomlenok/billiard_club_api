package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.SelectedTable;
import com.example.billiardclubapi.entity.BilliardTable;
import com.example.billiardclubapi.exception.AmountOfBilliardTableExceededException;
import com.example.billiardclubapi.exception.LimitOfCuesExceeded;
import com.example.billiardclubapi.exception.SelectedTableNotExistsException;
import com.example.billiardclubapi.repository.SelectedTableRepository;
import com.example.billiardclubapi.service.SelectedTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.billiardclubapi.util.ExceptionMessages.AMOUNT_BILLIARD_TABLE_EXCEEDED;
import static com.example.billiardclubapi.util.ExceptionMessages.SELECTED_TABLE_NOT_EXISTS;

@Service
@RequiredArgsConstructor
public class SelectedTableServiceImpl implements SelectedTableService {
    private final SelectedTableRepository selectedTableRepository;

    @Override
    public SelectedTable getById(Long id) {
        return getOrThrow(id);
    }

    @Override
    public List<SelectedTable> getAll(Long userId) {
        return selectedTableRepository.findSelectedTablesByUserId(userId);
    }

    @Transactional
    @Override
    public SelectedTable save(SelectedTable selectedTable) {
        Optional<SelectedTable> existingTable = selectedTableRepository.findSelectedTableByBilliardTableIdAndUserId(selectedTable.getBilliardTable().getId(), selectedTable.getUser().getId());

        if (existingTable.isPresent()) {
            selectedTable.setId(existingTable.get().getId());
            selectedTable.setAmount(existingTable.get().getAmount() + selectedTable.getAmount());
        }

        if (isEnoughAmount(selectedTable.getBilliardTable(), selectedTable)) {
            throw new AmountOfBilliardTableExceededException(AMOUNT_BILLIARD_TABLE_EXCEEDED);
        }

        return selectedTableRepository.save(selectedTable);
    }

    @Transactional
    @Override
    public SelectedTable update(SelectedTable selectedTable) {
        getOrThrow(selectedTable.getId());
        if (isEnoughAmount(selectedTable.getBilliardTable(), selectedTable)) {
            throw new AmountOfBilliardTableExceededException(AMOUNT_BILLIARD_TABLE_EXCEEDED);
        }
        return selectedTableRepository.save(selectedTable);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        getOrThrow(id);
        selectedTableRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteSelectedTablesByUserId(Long userId) {
        selectedTableRepository.deleteAllByUserId(userId);
    }

    private SelectedTable getOrThrow(Long id) {
        return selectedTableRepository.findById(id)
                .orElseThrow(() -> new SelectedTableNotExistsException(String.format(SELECTED_TABLE_NOT_EXISTS, id)));
    }

    private boolean isEnoughAmount(BilliardTable table, SelectedTable selectedTable) {
        return selectedTable.getAmount() > table.getAmount();
    }
}