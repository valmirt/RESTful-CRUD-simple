package com.dev.valmirt.crud.controller

import com.dev.valmirt.crud.model.User
import com.dev.valmirt.crud.service.UserService
import com.dev.valmirt.crud.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/users")
    fun getUsers(@RequestParam(value = "page", defaultValue = "0")
                 page: Int,
                 @RequestParam(value = "size", defaultValue = Constants.DEFAULT_SIZE)
                 size: Int): List<User>{

        return userService.getUsers(page, size)
    }

    @GetMapping("/users/{userId}")
    fun getUser(@PathVariable userId: Long): User {
        return userService.getUser(userId)
    }

    @PostMapping("/users")
    fun saveUser(@Valid @RequestBody user: User): User {
        val tempUser = User(0, user.firstName, user.lastName, user.email)

        return userService.saveUser(tempUser)
    }

    @PutMapping("/users")
    fun updateUser(@RequestBody user: User): User {
        return userService.saveUser(user)
    }

    @DeleteMapping("/users/{userId}")
    fun deleteUser(@PathVariable userId: Long): String {
        userService.deleteUser(userId)

        return "Deleted user id - $userId"
    }
}