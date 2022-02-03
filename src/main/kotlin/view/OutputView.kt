package view

import model.Car
import model.CarRecord
import model.CarRecords

private const val CAR_POSITION_SYMBOL = "-"
private const val WINNER_NAME_SEPARATOR = ","

fun printWinner(cars: List<Car>) {
    val winnerNames = cars.joinToString(WINNER_NAME_SEPARATOR) { car -> car.carName.value }
    println("$winnerNames 이(가) 최종 우승하였습니다.")
}

fun printCarRecords(carRecords: CarRecords) {
    repeat(carRecords.size) { count ->
        carRecords.getCarRecords(count)
            .forEach(::printCarRecord)
    }
}

private fun printCarRecord(car: CarRecord) {
    println("${car.name.value}: ${CAR_POSITION_SYMBOL.repeat(car.position.value)}")
}
