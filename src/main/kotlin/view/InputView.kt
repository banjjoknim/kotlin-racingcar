package view

fun pleaseInputCarNames() = println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)")

fun inputCarNames(): String {
    val carNames = readLine()
    require(!carNames.isNullOrBlank())
    return carNames
}
