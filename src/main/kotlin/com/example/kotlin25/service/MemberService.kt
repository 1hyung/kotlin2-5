package com.example.kotlin25.service

import com.example.kotlin25.controller.request.SignInRequest
import com.example.kotlin25.controller.request.SignUpRequest
import com.example.kotlin25.repository.MemberRepository
import com.example.kotlin25.repository.model.Member
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder : PasswordEncoder
) {
    fun signUp(signUpRequest: SignUpRequest): Boolean {
        //password 암호화 진행 ->bycrypt
        val encodedPassword = passwordEncoder.encode(signUpRequest.password)

        val member = Member(
            email = signUpRequest.email,
            password = encodedPassword,
            name = signUpRequest.name
        )
        memberRepository.save(member)
        return true
    }

    fun signIn(signInRequest: SignInRequest): String {
        // val isSame = passwordEncoder.matches(signInRequest.password, memberRepository)
        val member = memberRepository.findByEmail(signInRequest.email)
        if (member == null || !member.isCorrectPassword(passwordEncoder,signInRequest.password)) {
            throw IllegalArgumentException("Invalid email or password")
        }
        return "login success!" //token으로 리턴하는 방법 배우기
    }
}