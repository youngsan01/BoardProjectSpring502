package org.choongang.member.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.member.validators.JoinValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form) {
        return "front/member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors) { // RequestJoin 쪽으로 만들어줌

        joinValidator.validate(form, errors);

        if (errors.hasErrors()) { // errors 객체는 커멘드 객체에 대입해서 넣어줘야함.
            return "front/member/join";
        }

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login() {

        return "front/member/login";
    }
}
