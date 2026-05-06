package lotto

class LottoResult(val winningLotto: WinningLotto) {
    fun checkResult(lottos: List<Lotto>): Double {

        val totalPrize = lottos.mapNotNull { lotto ->
            val rank = winningLotto.checkResult(lotto)
            rank?.prize
        }.sum()

        return totalPrize.toDouble() * 100 / (lottos.size * 1000)
    }

    companion object {
        fun calculateProfitRate(
            purchaseAmount: Int,
            totalPrize: Int
        ): Double = totalPrize.toDouble() * 100 / purchaseAmount
    }
}