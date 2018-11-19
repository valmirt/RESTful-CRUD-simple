package com.dev.valmirt.crud.model

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
class User (@Id
            @GeneratedValue(strategy = GenerationType.SEQUENCE)
            var id: Long = 0,
            @NotBlank
            @Size(min = 3, max = 100)
            var firstName: String = "",
            @NotBlank
            @Size(min = 3, max = 100)
            var lastName: String = "",
            @NotBlank
            @Size(min = 3, max = 100)
            @Email
            var email: String = "") : AuditModel()