fun main() {

    val moneyTransfer = 5000f
    val previousСash = 78000f
    val typeCard = "Visa"
    val transfer: Float
    val comission = getMoneyComission(typeCard, previousСash, moneyTransfer)

    if (comission >= 0) {
        transfer = moneyTransfer + comission
        println(transfer)
    } else {
        println("Перевод не возможен - превышены суточные и/или месячные лимиты")
    }
}

fun getMoneyComission(typeCard: String = "Vk pay", previousСash: Float = 0f, moneyTransfer: Float): Float {

    val comission = when (typeCard) {

        "Mastercard", "Maestro" -> if (moneyTransfer <= 150000f && previousСash <= 600000f) {
            if (previousСash + moneyTransfer <= 75000) 0f else moneyTransfer * 0.006f + 20
        } else {
            -1f
        }

        "Visa", "Мир" -> if (moneyTransfer <= 150000f && previousСash <= 600000f) {
            if (moneyTransfer * 0.0075 > 35) moneyTransfer * 0.0075f else 35f
        } else {
            -1f
        }

        else -> if (moneyTransfer <= 15000f && previousСash <= 40000f) {
            0f
        } else {
            -1f
        }
    }

    return comission
}