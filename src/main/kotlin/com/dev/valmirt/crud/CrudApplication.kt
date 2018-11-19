package com.dev.valmirt.crud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class CrudApplication

fun main(args: Array<String>) {
    runApplication<CrudApplication>(*args)
}
