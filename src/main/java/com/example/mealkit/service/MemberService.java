package com.example.mealkit.service;

import com.example.mealkit.dto.MemberDto;
import com.example.mealkit.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDto memberDto) {
    }
}
