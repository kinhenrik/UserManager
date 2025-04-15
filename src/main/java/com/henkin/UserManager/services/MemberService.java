package com.henkin.UserManager.services;

import com.henkin.UserManager.entities.Member;
import com.henkin.UserManager.exceptions.ResourceNotFoundException;
import com.henkin.UserManager.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements MemberServiceInterface {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            return member.get();
        }
        throw new ResourceNotFoundException("Member", "id", id);
    }

    @Override
    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMemberById(Long id) {
        memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
        memberRepository.deleteById(id);
    }
}
