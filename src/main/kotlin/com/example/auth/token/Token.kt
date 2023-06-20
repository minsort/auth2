package com.example.auth.token

import com.example.auth.user.Users
import jakarta.persistence.*

@Entity
data class Token(
    @Id
    @GeneratedValue
    var id: Int? = null,

    @Column(unique = true)
    var token: String? = null,

    @Enumerated(EnumType.STRING)
    var tokenType: TokenType = TokenType.BEARER,

    var revoked: Boolean = false,

    var expired: Boolean = false,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var users: Users? = null
)