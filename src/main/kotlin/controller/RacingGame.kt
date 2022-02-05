package controller

import model.Cars
import model.TryCount
import view.printGameResult

class RacingGame(private val _cars: Cars, private val _tryCount: TryCount) {
    fun run(movableFunction: () -> Boolean) {
        val carRecords = _cars.race(_tryCount, movableFunction)
        val winners = _cars.findWinners()
        printGameResult(carRecords, winners)
    }
}
