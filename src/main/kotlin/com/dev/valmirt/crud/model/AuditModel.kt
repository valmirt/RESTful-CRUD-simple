package com.dev.valmirt.crud.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.util.*
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
@JsonIgnoreProperties(
        value = ["createdAt", "updateAt"],
        allowGetters = true
)
abstract class AuditModel (@Temporal(TemporalType.DATE)
                           @Column(name = "created_at", nullable = false, updatable = false)
                           @CreatedDate
                           var createdAt: Date? = null,
                           @Temporal(TemporalType.DATE)
                           @Column(name = "updated_at", nullable = false)
                           @LastModifiedDate
                           var updateAt: Date? = null) : Serializable