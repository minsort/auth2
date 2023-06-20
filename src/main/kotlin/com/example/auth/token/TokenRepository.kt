package com.example.auth.token

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface TokenRepository : JpaRepository<Token, Int> {

    @Query(
        value = """
      select t from Token t inner join Users u
      on t.users.id = u.id
      where u.id = :id and (t.expired = false or t.revoked = false)
      """
    )

    fun findAllValidTokenByUser(id: Int): List<Token>

    fun findByToken(token: String): Optional<Token>

}