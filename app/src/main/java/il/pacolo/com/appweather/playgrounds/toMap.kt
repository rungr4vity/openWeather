package il.pacolo.com.appweather.playgrounds



fun main() {

    val transactions = listOf(
        Transaction(1,"First",2.00)
        ,Transaction(2,"Second",5.00)
        ,Transaction(3,"Third",null)
    )

    val resultado = transactions.map { transaction ->
        runCatching {
            executeTransactions(transaction)
            println("Executed transaction: ${transaction.name}")
        }.getOrElse { exception ->
            println("Error: $exception")
            null
        }
    }

    println(resultado.toList())
}

fun executeTransactions(transaction: Transaction) {
        val error = 5/transaction.amount!!

}

data class Transaction(val id: Int,val name:String,val amount:Double?)
