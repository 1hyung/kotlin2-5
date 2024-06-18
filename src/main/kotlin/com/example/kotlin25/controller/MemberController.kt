package com.example.kotlin25.controller

import com.example.kotlin25.controller.request.SignInRequest
import com.example.kotlin25.controller.request.SignUpRequest
import com.example.kotlin25.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class MemberController (
    private val memberService: MemberService
){
    @PostMapping("/sign-up")
    fun signUp(
        @RequestBody request: SignUpRequest
    ): ResponseEntity<Boolean> {
        return ResponseEntity.ok(
            memberService.signUp(request)
        )
    }

    @PostMapping("/sign-in")
    fun signIn(
        @RequestBody request: SignInRequest
    ): ResponseEntity<String> {
        return ResponseEntity.ok(
            memberService.signIn(request)
        )
    }

}