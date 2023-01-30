package com.jb.transactionvalidation.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import com.jb.transactionvalidation.service.TransactionService
import com.jb.transactionvalidation.util.AmountDto
import com.jb.transactionvalidation.util.exception.InvalidAmountException
import org.springframework.web.bind.annotation.RequestBody

@RestController
class TransactionController {

    @Autowired
    lateinit var transactionService: TransactionService

    @PostMapping("/antifraud/transaction")
    fun evaluateTransaction(@RequestBody amountDto: AmountDto) = transactionService.evaluateTransactionAmount(
        amountDto.amount ?: throw InvalidAmountException("Amount must not be null")
    ).name

}