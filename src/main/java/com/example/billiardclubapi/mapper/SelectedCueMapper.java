package com.example.billiardclubapi.mapper;

import com.example.billiardclubapi.dto.request.selectedcue.SelectedCueRequest;
import com.example.billiardclubapi.dto.response.selectedcue.SelectedCueListResponse;
import com.example.billiardclubapi.dto.response.selectedcue.SelectedCueResponse;
import com.example.billiardclubapi.entity.SelectedCue;
import com.example.billiardclubapi.service.CueService;
import com.example.billiardclubapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SelectedCueMapper {
    private final CueService cueService;
    private final CueMapper cueMapper;
    private final UserService userService;

    public SelectedCue toEntity(SelectedCueRequest request, Long userId) {
        return SelectedCue.builder()
                .amount(request.amount())
                .user(userService.getById(userId))
                .cue(cueService.getById(request.cue()))
                .build();
    }

    public SelectedCue toEntity(Long id, SelectedCueRequest request, Long userId) {
        return SelectedCue.builder()
                .id(id)
                .amount(request.amount())
                .user(userService.getById(userId))
                .cue(cueService.getById(request.cue()))
                .build();
    }

    public SelectedCueResponse toResponse(SelectedCue selectedCue) {
        return SelectedCueResponse.builder()
                .id(selectedCue.getId())
                .amount(selectedCue.getAmount())
                .cue(cueMapper.toResponse(selectedCue.getCue()))
                .build();
    }

    public SelectedCueListResponse toListResponse(List<SelectedCue> selectedCueList) {
        List<SelectedCueResponse> selectedCueResponseList = selectedCueList.stream()
                .map(this::toResponse)
                .toList();
        return SelectedCueListResponse.builder()
                .items(selectedCueResponseList)
                .build();
    }
}
