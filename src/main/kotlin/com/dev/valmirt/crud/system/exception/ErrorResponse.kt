package com.dev.valmirt.crud.system.exception

data class ErrorResponse(val status: Int = 0,
                         val message: String? = "",
                         val timeStamp: Long = 0L)