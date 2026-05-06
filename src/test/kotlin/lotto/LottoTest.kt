package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또는 6개이다`() {
        shouldNotThrowAny { Lotto(1, 2, 3, 4, 5, 6) }
        shouldThrow<IllegalArgumentException> { Lotto(1, 2, 3, 4, 5) }
    }

    @Test
    fun `로또는 중복되지 않는다`() {
        shouldNotThrowAny { Lotto(1, 2, 3, 4, 5, 6) }
        shouldThrow<IllegalArgumentException> { Lotto(1, 1, 1, 1, 1, 1) }
    }
}
