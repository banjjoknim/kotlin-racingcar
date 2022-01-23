package view

fun inputCarNames(): String {
    pleaseInputCarNames()
    val carNames = readLine()
    require(!carNames.isNullOrBlank())
    return carNames
}

private fun pleaseInputCarNames() = println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)")

fun inputTryCount(): Int {
    pleaseInputTryCount()
    val tryCount = readLine()?.toIntOrNull()
    requireNotNull(tryCount)
    return tryCount
}

private fun pleaseInputTryCount() = println("시도할 횟수는 몇회인가요?")
