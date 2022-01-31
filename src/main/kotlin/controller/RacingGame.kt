package controller

import model.Cars
import model.TryCount
import view.printCarsStatus
import view.printResult

class RacingGame(private val _cars: Cars, private val _tryCount: TryCount) {
    fun run(movableFunction: () -> Boolean) {
        repeat(_tryCount.value) {
            _cars.race(movableFunction)
            printCarsStatus(_cars)
        }
        val winners = _cars.findWinners()
        printResult(winners)
    }
}
