package lotto

data class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { "로또 번호는 1에서 45 사이여야 합니다." }
    }
}