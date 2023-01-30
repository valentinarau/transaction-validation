package service

import com.jb.transactionvalidation.service.TransactionService
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import com.jb.transactionvalidation.util.Evaluation
import com.jb.transactionvalidation.util.exception.InvalidAmountException

class TransactionServiceTest {

    private val underTest = TransactionService()
    private val allowedAmount = 200
    private val requiresManualProcessAmount = 201
    private val prohibitedAmount = 1501
    private val invalidAmount = -1

    @Test
    fun shouldReturnAllowedWhenAmountIsAllowed() {
        assertEquals(Evaluation.ALLOWED, underTest.evaluateTransactionAmount(allowedAmount))
    }

    @Test
    fun shouldReturnManualProcessingWhenAmountRequiresManualProcessing() {
        assertEquals(Evaluation.MANUAL_PROCESSING, underTest.evaluateTransactionAmount(requiresManualProcessAmount))
    }

    @Test
    fun shouldReturnProhibitedWhenAmountExceeds() {
        assertEquals(Evaluation.PROHIBITED, underTest.evaluateTransactionAmount(prohibitedAmount))
    }

    @Test
    fun shouldThrowWhenAmountIsInvalid() {
        assertThrows(InvalidAmountException::class.java) { underTest.evaluateTransactionAmount(invalidAmount) }
    }
}