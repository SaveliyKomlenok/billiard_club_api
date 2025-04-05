package com.example.billiardclubapi.service.impl;

import com.example.billiardclubapi.entity.Cue;
import com.example.billiardclubapi.service.CueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CueServiceImpl implements CueService {
    @Override
    public Cue getById(Long id) {
        return null;
    }

    @Override
    public List<Cue> getAll() {
        return null;
    }

    @Override
    public Cue save(Cue Cue) {
        return null;
    }

    @Override
    public Cue update(Cue Cue) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public String getImagePath(Long id) {
        return null;
    }
}
