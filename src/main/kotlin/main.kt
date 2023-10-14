fun main() {
    val moneyTransfer = 12500f
    val previousСash = 85000f
    val typeCard = "Visa"

    val transfer = moneyTransfer + getMoneyComission(typeCard, previousСash, moneyTransfer)

    println(transfer)
}

fun getMoneyComission(typeCard: String = "Vk pay", previousСash: Float = 0f, moneyTransfer: Float): Float {

    val comission = when (typeCard) {
        "Mastercard" -> if (previousСash <= 75000) 0f else moneyTransfer * 0.006f + 20
        "Maestro" -> if (previousСash <= 75000) 0f else moneyTransfer * 0.006f + 20
        "Visa" -> if (moneyTransfer > 35) moneyTransfer * 0.0075f else 35f
        "Мир" -> if (moneyTransfer > 35) moneyTransfer * 0.0075f else 35f
        else -> 0f
    }

    return comission
}