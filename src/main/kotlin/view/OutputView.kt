package view

import model.Car
import model.Cars

private const val CAR_POSITION_SYMBOL = "-"
private const val WINNER_NAME_SEPARATOR = ","

fun printResult(cars: List<Car>) {
    val winnerNames = cars.joinToString(WINNER_NAME_SEPARATOR) { car -> car.carName.value }
    println("$winnerNames 이(가) 최종 우승하였습니다.")
}

fun printCarsStatus(cars: Cars) {
    cars.cars.forEach(::printCarStatus)
    println()
}

private fun printCarStatus(car: Car) {
    println("${car.carName.value}: ${CAR_POSITION_SYMBOL.repeat(car.position.value)}")
}
