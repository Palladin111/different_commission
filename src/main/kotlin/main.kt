fun main() {
    val moneyTransfer = 14100f
    val previousСash = 85000f
    val typeCard = "VK Pay"
    val transfer: Float
    val monthLimit = 12000f

    when (typeCard) {

        "Mastercard", "Maestro", "Visa", "Мир" -> if (moneyTransfer <= 150000f && monthLimit <= 600000f) {
            transfer = moneyTransfer + getMoneyComission(typeCard, previousСash, moneyTransfer)
            println(transfer)
        } else {
            println("Превышены суточный и/или месячный лимиты на перевод денег.")
        }

        "VK Pay" -> if (moneyTransfer <= 15000f && monthLimit <= 40000) {
            transfer = moneyTransfer + getMoneyComission(typeCard, previousСash, moneyTransfer)
            println(transfer)
        } else {
            println("Превышены суточный и/или месячный лимиты на перевод денег.")
        }

        else -> println("Вы ошиблись при вводе платежной системы")
    }
}

fun getMoneyComission(typeCard: String = "Vk pay", previousСash: Float = 0f, moneyTransfer: Float): Float {

    val comission = when (typeCard) {
        "Mastercard" -> if (previousСash + moneyTransfer <= 75000) 0f else moneyTransfer * 0.006f + 20
        "Maestro" -> if (previousСash <= 75000) 0f else moneyTransfer * 0.006f + 20
        "Visa" -> if (moneyTransfer > 35) moneyTransfer * 0.0075f else 35f
        "Мир" -> if (moneyTransfer > 35) moneyTransfer * 0.0075f else 35f
        else -> 0f
    }

    return comission
}