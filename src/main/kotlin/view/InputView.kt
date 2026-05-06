package view

import lotto.Lotto
import lotto.LottoNumber
import lotto.WinningLotto


class InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        while (true) {
            val input = readlnOrNull() ?: continue
            val amount = input.toIntOrNull()
            when {
                amount == null -> print("[ERROR] 금액을 입력하십시오\n")
                amount < 0 -> print("[ERROR] 금액을 양수로 입력하십시오.\n")
                amount % 1000 != 0 -> print("[ERROR] 금액을 천원 단위로 입력하십시오.\n")
                else -> return amount
            }
        }
    }

    fun readWinningNumber(): List<LottoNumber> {
        println("\n당첨 번호를 입력해 주세요.")
        while (true) {
            val input = readlnOrNull() ?: continue
            val numbers = input.split(",").map { it.trim().toIntOrNull() }
            runCatching {
                return numbers.filterNotNull().map { LottoNumber(it) }
            }.onFailure { println("[ERROR] ${it.message}") }
        }
    }

    fun readBonusNumber(winningNumbers: List<LottoNumber>): WinningLotto {
        println("\n보너스 번호를 입력해 주세요.")
        while (true) {
            val input = readlnOrNull() ?: continue
            val bonusNumber = input.toIntOrNull()
            runCatching {
                if (bonusNumber == null) print("[ERROR] 보너스 번호를 입력해 주세요.")
                else return WinningLotto(numbers = winningNumbers, bonusNumber = LottoNumber(bonusNumber))
            }.onFailure { println("[ERROR] ${it.message}") }

        }
    }
}