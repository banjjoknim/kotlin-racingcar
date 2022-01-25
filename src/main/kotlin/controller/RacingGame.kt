package controller

import model.Car
import model.Cars

class RacingGame(private val _cars: Cars) {

    fun run(movableFunction: () -> Boolean) {
        _cars.race(movableFunction)
    }

    fun findWinners(): List<Car> {
        return _cars.findWinners()
    }

    val cars
        get() = _cars
}
