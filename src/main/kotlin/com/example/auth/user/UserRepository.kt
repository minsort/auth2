package com.example.auth.user

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<Users, Int>{
    fun findByEmail(email :String) :Optional<Users>
}