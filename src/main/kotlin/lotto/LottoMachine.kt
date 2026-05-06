package lotto

class LottoMachine {

    fun issueByAmount(amount: Int): List<Lotto> {
        require(amount % 1000 == 0) { "구입 금액은 1000원 단위여야 합니다."}
        require(amount > 0) { "구입 금액은 양수 여야 합니다."}

        val count = amount / 1000
        return issue(count)
    }

    fun issue(count: Int): List<Lotto> =
        (1..count).map {
            val numbers: List<Int> = (1..45).shuffled().take(6).sorted()
            Lotto(*numbers.toIntArray())
        }
}