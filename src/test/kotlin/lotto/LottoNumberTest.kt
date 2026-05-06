package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `로또 번호의 숫자 범위는 1~45까지이다`() {
        shouldNotThrowAny { LottoNumber(1) }
        shouldThrow<IllegalArgumentException> { LottoNumber(46) }
    }
}