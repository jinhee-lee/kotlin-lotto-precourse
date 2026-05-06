package lotto

data class WinningLotto(
    val numbers: List<LottoNumber>,
    val bonusNumber: LottoNumber
) {
    fun checkResult(lotto: Lotto): Rank? {
        val matchCount = numbers.count { lotto.numbers.contains(it) }
        val matchBonus = lotto.numbers.contains(bonusNumber)
        return Rank.getRank(matchCount, matchBonus)
    }

    constructor(numbers: List<Int>, bonusNumber: Int) : this(numbers.map { LottoNumber(it) }, LottoNumber(bonusNumber))

    init {
        require((numbers + bonusNumber).distinct().size == 7) { "당첨번호와 보너스 번호는 중복되지 않습니다." }
    }

}