package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.SelectedCue;
import com.example.billiardclubapi.entity.Cue;
import com.example.billiardclubapi.exception.SelectedCueNotExistsException;
import com.example.billiardclubapi.exception.AmountOfCueExceededException;
import com.example.billiardclubapi.repository.SelectedCueRepository;
import com.example.billiardclubapi.service.SelectedCueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.billiardclubapi.util.ExceptionMessages.AMOUNT_CUE_EXCEEDED;
import static com.example.billiardclubapi.util.ExceptionMessages.SELECTED_CUE_NOT_EXISTS;

@Service
@RequiredArgsConstructor
public class SelectedCueServiceImpl implements SelectedCueService {
    private final SelectedCueRepository selectedCueRepository;

    @Override
    public SelectedCue getById(Long id) {
        return getOrThrow(id);
    }

    @Override
    public List<SelectedCue> getAll(Long userId) {
        return selectedCueRepository.findSelectedCuesByUserId(userId);
    }

    @Transactional
    @Override
    public SelectedCue save(SelectedCue selectedCue) {
        Optional<SelectedCue> existingCue = selectedCueRepository.findSelectedCueByCueIdAndUserId(selectedCue.getCue().getId(), selectedCue.getUser().getId());

        if (existingCue.isPresent()) {
            selectedCue.setId(existingCue.get().getId());
            selectedCue.setAmount(existingCue.get().getAmount() + selectedCue.getAmount());
        }

        if (isEnoughAmount(selectedCue.getCue(), selectedCue)) {
            throw new AmountOfCueExceededException(AMOUNT_CUE_EXCEEDED);
        }

        return selectedCueRepository.save(selectedCue);
    }

    @Transactional
    @Override
    public SelectedCue update(SelectedCue selectedCue) {
        getOrThrow(selectedCue.getId());
        if (isEnoughAmount(selectedCue.getCue(), selectedCue)) {
            throw new AmountOfCueExceededException(AMOUNT_CUE_EXCEEDED);
        }
        return selectedCueRepository.save(selectedCue);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        getOrThrow(id);
        selectedCueRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteSelectedCuesByUserId(Long userId) {
        selectedCueRepository.deleteAllByUserId(userId);
    }

    private SelectedCue getOrThrow(Long id) {
        return selectedCueRepository.findById(id)
                .orElseThrow(() -> new SelectedCueNotExistsException(String.format(SELECTED_CUE_NOT_EXISTS, id)));
    }

    private boolean isEnoughAmount(Cue cue, SelectedCue selectedCue) {
        return selectedCue.getAmount() > cue.getAmount();
    }
}