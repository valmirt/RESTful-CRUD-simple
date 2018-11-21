package com.dev.valmirt.crud.repository

import com.dev.valmirt.crud.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>{

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    fun findByEmail(email: String): User?

    @Query("SELECT u FROM User u WHERE u.firstName = ?1")
    fun findByFirstName(firstName: String): List<User>?

    @Query("SELECT u FROM User u WHERE u.lastName = ?1")
    fun findByLastName(lastName: String): List<User>?
}