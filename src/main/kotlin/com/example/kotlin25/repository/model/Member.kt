package com.example.kotlin25.repository.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.crypto.password.PasswordEncoder

@Entity(name = "member-chan")
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null,
    @Column(unique = true)
    private var email: String = "",
    private var password: String = "",
    private var name: String = "",
    private var role: MemberRole = MemberRole.USER
) {
    enum class MemberRole {
        USER, ADMIN
    }

    //can or is로 시작한다면 boolean 타입으로 반환한다.
    fun isCorrectPassword(passwordEncoder:PasswordEncoder, password: String): Boolean {
        return passwordEncoder.matches(password, this.password)
        // return this.password == password
    }
}