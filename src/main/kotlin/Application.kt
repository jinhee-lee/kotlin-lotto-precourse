import lotto.LottoMachine
import lotto.LottoResult
import view.InputView


fun main() {
    val purchaseAmount = InputView().readPurchaseAmount()
    val lottos = LottoMachine().issueByAmount(purchaseAmount)

    println("\n${lottos.size} 개를 구매했습니다.")
    lottos.forEach {
        println("[${it.numbers.map { it.number }.joinToString(",")}]")
    }

    val winningNumbers = InputView().readWinningNumber()
    val winningLotto = InputView().readBonusNumber(winningNumbers)

    val profitRate = LottoResult(winningLotto).checkResult(lottos)

    println("총 수익률은 ${"%.1f".format(profitRate)}%입니다.")

}

