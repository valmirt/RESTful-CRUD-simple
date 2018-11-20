package com.dev.valmirt.crud.repository

import com.dev.valmirt.crud.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>