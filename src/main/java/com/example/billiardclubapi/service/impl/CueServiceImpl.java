package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.Cue;
import com.example.billiardclubapi.exception.CueNotExistsException;
import com.example.billiardclubapi.repository.CueRepository;
import com.example.billiardclubapi.service.CueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.billiardclubapi.util.ExceptionMessages.CUE_NOT_EXISTS;

@Service
@RequiredArgsConstructor
public class CueServiceImpl implements CueService {
    private final CueRepository cueRepository;

    @Override
    public Cue getById(Long id) {
        return getOrThrow(id);
    }

    @Override
    public List<Cue> getAll() {
        return cueRepository.findAll();
    }

    @Transactional
    @Override
    public Cue save(Cue cue) {
        return cueRepository.save(cue);
    }

    @Transactional
    @Override
    public Cue update(Cue cue) {
        getOrThrow(cue.getId());
        return cueRepository.save(cue);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        getOrThrow(id);
        cueRepository.deleteById(id);
    }

    @Override
    public String getImagePath(Long id) {
        return getOrThrow(id).getImagePath();
    }

    private Cue getOrThrow(Long id) {
        return cueRepository.findById(id)
                .orElseThrow(() -> new CueNotExistsException(String.format(CUE_NOT_EXISTS, id)));
    }
}