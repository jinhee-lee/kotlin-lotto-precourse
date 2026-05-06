package lotto

data class Lotto(val numbers: List<LottoNumber>) {
    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber(it) })

    init {
        require(numbers.distinct().size == 6) { "로또 번호는 6개 여야 합니다." }
    }
}