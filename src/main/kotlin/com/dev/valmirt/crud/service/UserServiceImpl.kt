package com.dev.valmirt.crud.service

import com.dev.valmirt.crud.model.User
import com.dev.valmirt.crud.repository.UserRepository
import com.dev.valmirt.crud.system.exception.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class UserServiceImpl: UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun getUsers(page: Int, size: Int): List<User> {
        val currentPage = userRepository.findAll(PageRequest.of(page, size))
        return currentPage.content
    }

    override fun getUser(id: Long): User {
        return userRepository.findById(id).orElseThrow {
            UserNotFoundException("User not found with id $id")
        }
    }

    override fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    override fun deleteUser(id: Long) {
        return userRepository.deleteById(id)
    }
}