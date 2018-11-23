package com.dev.valmirt.crud.service

import com.dev.valmirt.crud.model.User

interface UserService {

    fun getUsers(page: Int, size: Int): List<User>

    fun getUser(id: Long): User

    fun saveUser(user: User): User

    fun deleteUser(id: Long)
}