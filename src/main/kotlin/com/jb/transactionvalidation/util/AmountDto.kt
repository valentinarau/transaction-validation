package com.jb.transactionvalidation.util

// Could have use @NotNull annotation but i still had to handle the field as nullable,
// so in order to reduce extra code, i just decided not to use it
data class AmountDto(val amount: Int?)