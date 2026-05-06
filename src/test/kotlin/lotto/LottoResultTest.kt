package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `구매한 로또의 결과를 모두 확인한다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottos = listOf(Lotto(1, 2, 3, 43, 44, 45))

        shouldNotThrowAny { LottoResult(winningLotto).checkResult(lottos) }
        LottoResult(winningLotto).checkResult(lottos) shouldBe 500.0
    }

    @Test
    fun `수익율을 계산한다`() {
        LottoResult.calculateProfitRate(purchaseAmount = 1_000, totalPrize = 5_000) shouldBe 500.0
        LottoResult.calculateProfitRate(purchaseAmount = 1_000, totalPrize = 0) shouldBe 0.0
        LottoResult.calculateProfitRate(purchaseAmount = 5_000, totalPrize = 5_000) shouldBe 100.0
    }
}