package com.example.mealkit.service;

import com.example.mealkit.dto.MemberDto;
import com.example.mealkit.entity.MemberEntity;
import com.example.mealkit.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDto memberDto) {
        // 1. dto -> entity 변환
        MemberEntity memberentity = MemberEntity.toMemberentity(memberDto);
        // 2. repository 의 save 메서드 호출
        memberRepository.save(memberentity);
        // repository 의 save 메서드 호출(조건, entity 객체를 넘겨줘야함)

    }

    public MemberDto login(MemberDto memberDto) {
        // 1. 회원이 입력한 이메일로 DB에서 조회함
        // 2. DB 에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        Optional<MemberEntity> allByMemberEmail = memberRepository.findAllByMemberEmail(memberDto.getMemberEmail());
        if (allByMemberEmail.isPresent()){
            // 조회 결과가 있다
            MemberEntity memberEntity = allByMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(memberDto.getMemberPassword())){
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                MemberDto dto = MemberDto.toMemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 불일치
                return null;
            }
        }else {
            // 조회 결과가 없다
            return null;
        }
    }
}
