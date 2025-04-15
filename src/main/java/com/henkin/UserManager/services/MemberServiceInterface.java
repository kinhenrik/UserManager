package com.henkin.UserManager.services;

import com.henkin.UserManager.entities.Member;

import java.util.List;

public interface MemberServiceInterface {

    List<Member> getAllMembers();
    Member getMemberById(long id);
    Member updateMember(Member member);
    Member addMember(Member member);
    void deleteMemberById(Long id);

}
