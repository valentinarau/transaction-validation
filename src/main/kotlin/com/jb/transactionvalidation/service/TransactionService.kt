package com.jb.transactionvalidation.service

import org.springframework.stereotype.Service
import com.jb.transactionvalidation.util.Evaluation
import com.jb.transactionvalidation.util.exception.InvalidAmountException

@Service
class TransactionService {

    fun evaluateTransactionAmount(amount: Int) : Evaluation {
        if(amount < 0){
            throw InvalidAmountException("Invalid input amount")
        }
        return if(amount <= ALLOWED_AMOUNT){
            Evaluation.ALLOWED
        } else if(amount <= MANUAL_PROCESSING_AMOUNT){
            Evaluation.MANUAL_PROCESSING
        } else Evaluation.PROHIBITED
    }

    companion object {
        const val ALLOWED_AMOUNT = 200
        const val MANUAL_PROCESSING_AMOUNT = 1500
    }

}