package com.example.auth.user

import com.example.auth.token.Token
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "users")
data class Users(
    @Id
    @GeneratedValue
    val id: Int? = null,
    val firstname: String? = null,
    val lastname: String? = null,
    val email: String? = null,
    val password: String? = null,

    @Enumerated(EnumType.STRING)
    val role: Role? = null,

    @OneToMany(mappedBy = "users")
    val tokens: List<Token>? = null
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return role?.getAuthorities() ?: emptyList()
    }

    override fun getPassword(): String? {
        return password
    }

    override fun getUsername(): String? {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

}