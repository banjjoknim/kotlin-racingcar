
import model.CarNames
import model.Cars
import model.RacingGame
import model.TryCount
import model.randomMovableFunction
import view.inputCarNames
import view.inputTryCount
import view.printCarsStatus
import view.printResult

fun main() {
    val cars = Cars(CarNames(inputCarNames()))
    val tryCount = TryCount(inputTryCount())
    var racingGame = RacingGame(cars)
    repeat(tryCount.value) {
        racingGame.run(randomMovableFunction())
        printCarsStatus(racingGame.cars)
    }
    val winners = racingGame.findWinners()
    printResult(winners)
}
