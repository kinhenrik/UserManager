package com.henkin.UserManager.controllers;

import com.henkin.UserManager.entities.Member;
import com.henkin.UserManager.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    @ResponseBody
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/member/{id}")
    @ResponseBody
    public ResponseEntity<Member> getMemberById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PutMapping("/updatemember")
    @ResponseBody
    public ResponseEntity<Member> updateMemberById(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMember(member));
    }

    @PostMapping("/addmember")
    @ResponseBody
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.addMember(member), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletemember/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMemberById(id);
        return ResponseEntity.ok("Member with id " + id + " has been removed.");
    }

    //THYMELEAF
    @GetMapping("/deletemember")
    public String listAllMembers(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "deletemember";
    }

    @GetMapping("/deleteMemberById/{id}")
    public String deleteMemberById(@PathVariable("id") Long id) {
        memberService.deleteMemberById(id);
        return "redirect:/admin/deletemember";
    }

}
