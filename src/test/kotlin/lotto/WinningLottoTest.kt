package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `당첨 번호 6개와 보너스 번호1개는 중복 되지 않는다`() {
        shouldNotThrowAny { WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7) }
        shouldThrow<IllegalArgumentException> { WinningLotto(listOf(1, 2, 3, 4, 5, 7), 7) }

    }

    @Test
    fun `당첨 번호 5개면 에러를 발생한다`() {
        shouldThrow<IllegalArgumentException> { WinningLotto(listOf(1, 2, 3, 4, 5), 7) }
    }

    @Test
    fun ` 구매한 로또 번호와 당첨 번호가 6개 일치하면 1등 결과를 반환한다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        winningLotto.checkResult(lotto) shouldBe  Rank.FIRST
    }

    @Test
    fun ` 구매한 로또 번호와 당첨 번호가 5개와 보너스 번호 1개 일치하면 2등 결과를 반환한다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(1, 2, 3, 4, 5, 7)
        winningLotto.checkResult(lotto) shouldBe  Rank.SECOND
    }

    @Test
    fun ` 구매한 로또 번호와 당첨 번호가 5개가 일치하고 보너스 번호 1개  불일치하면 3등 결과를 반환한다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(1, 2, 3, 4, 5, 45)
        winningLotto.checkResult(lotto) shouldBe  Rank.THIRD
    }


    @Test
    fun ` 구매한 로또 번호와 당첨 번호가 4개 일치하면 4등 결과를 반환한다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(1, 2, 3, 4, 44, 45)
        winningLotto.checkResult(lotto) shouldBe  Rank.FOURTH
    }

    @Test
    fun ` 구매한 로또 번호와 당첨 번호가 3개 일치하면 3등 결과를 반환한다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(1, 2, 3, 43, 44, 45)
        winningLotto.checkResult(lotto) shouldBe  Rank.FIFTH
    }

    @Test
    fun ` 구매한 로또 번호와 당첨 번호가 2개 이하 일치하면 null을 반환한다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(1, 2, 32, 43, 44, 45)
        winningLotto.checkResult(lotto) shouldBe  null
    }
}