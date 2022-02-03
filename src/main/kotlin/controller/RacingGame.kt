package controller

import model.Cars
import model.TryCount
import view.printCarRecords
import view.printWinner

class RacingGame(private val _cars: Cars, private val _tryCount: TryCount) {
    fun run(movableFunction: () -> Boolean) {
        val carRecords = _cars.race(_tryCount, movableFunction)
        printCarRecords(carRecords)
        val winners = _cars.findWinners()
        printWinner(winners)
    }
}
