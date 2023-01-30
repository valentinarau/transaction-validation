package com.jb.transactionvalidation.util.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
class InvalidAmountException(cause: String) : RuntimeException(cause)