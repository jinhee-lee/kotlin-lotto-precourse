package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `로또를 발행한다`() {
        val lottos: List<Lotto> = LottoMachine().issue(10)
        lottos.size shouldBe 10
    }

    @Test
    fun `로또 구입 금액에 해당하는 만큼 로또를 발행해야 한다`() {
        val lottos: List<Lotto> = LottoMachine().issueByAmount(8000)
        lottos.size shouldBe 8
    }

    @Test
    fun `구입 금액은 1000 원 단위로 입력 받는다`() {
        shouldNotThrowAny { LottoMachine().issueByAmount(1000) }
        shouldThrow<IllegalArgumentException> { LottoMachine().issueByAmount(9999) }
    }

    @Test
    fun `구입 금액은 양수로 입력 받는다`() {
        shouldNotThrowAny { LottoMachine().issueByAmount(1000) }
        shouldThrow<IllegalArgumentException> { LottoMachine().issueByAmount(-1000) }

    }
}