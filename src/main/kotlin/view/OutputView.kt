package view

import model.Car
import model.CarRecord
import model.CarRecords

private const val CAR_POSITION_SYMBOL = "-"
private const val CAR_NAME_SEPARATOR = ","
private const val BLANK_LINE = "\n"

fun printGameResults(carRecords: CarRecords, winners: List<Car>) {
    println(carRecords.toText())
    println("${winners.toNamesText()} 이(가) 최종 우승하였습니다.")
}

private fun List<Car>.toNamesText(): String {
    return this.joinToString(CAR_NAME_SEPARATOR) { car -> car.carName.value }
}

private fun CarRecords.toText(): String {
    return this.carRecords.joinToString(BLANK_LINE) { carRecords -> carRecords.toText() }
}

private fun List<CarRecord>.toText(): String {
    return this.joinToString(BLANK_LINE) { carRecord -> carRecord.toText() } + BLANK_LINE
}

private fun CarRecord.toText(): String {
    return "${this.name.value}: ${CAR_POSITION_SYMBOL.repeat(this.position.value)}"
}
