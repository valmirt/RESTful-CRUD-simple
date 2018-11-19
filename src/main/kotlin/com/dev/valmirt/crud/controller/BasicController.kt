package com.dev.valmirt.crud.controller

import com.dev.valmirt.crud.model.User

open class BasicController {

    protected fun checkUpdateData(tempUser: User, baseUser: User) : User {

        if (!baseUser.firstName.isEmpty()
                && tempUser.firstName != baseUser.firstName)
            tempUser.firstName = baseUser.firstName
        if (!baseUser.lastName.isEmpty()
                && tempUser.lastName != baseUser.lastName)
            tempUser.lastName = baseUser.lastName
        if (!baseUser.email.isEmpty()
                && tempUser.email != baseUser.email)
            tempUser.email = baseUser.email

        return tempUser
    }
}