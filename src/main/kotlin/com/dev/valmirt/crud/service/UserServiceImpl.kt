package com.dev.valmirt.crud.service

import com.dev.valmirt.crud.model.User
import com.dev.valmirt.crud.repository.UserRepository
import com.dev.valmirt.crud.system.exception.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.lang.Exception

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
        if (user.id != 0L){
            val tempUser: User? = userRepository.findByEmail(user.email)
            if (tempUser != null) throw Exception("This email is already registered")
            return userRepository.save(checkUpdateUser(user))
        }
        return userRepository.save(user)
    }

    override fun deleteUser(id: Long) {
        val user = getUser(id)
        return userRepository.delete(user)
    }

    private fun checkUpdateUser(user: User) : User {
        val tempUser = getUser(user.id)

        if (!user.firstName.isEmpty()
                && tempUser.firstName != user.firstName)
            tempUser.firstName = user.firstName
        if (!user.lastName.isEmpty()
                && tempUser.lastName != user.lastName)
            tempUser.lastName = user.lastName
        if (!user.email.isEmpty()
                && tempUser.email != user.email)
            tempUser.email = user.email

        return tempUser
    }
}