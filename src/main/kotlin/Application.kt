
import model.CarNames
import model.Cars
import model.RacingGame
import model.TryCount
import view.inputCarNames
import view.inputTryCount
import view.printCarsStatus
import view.printResult
import kotlin.random.Random

fun main() {
    val cars = Cars(CarNames(inputCarNames()))
    val tryCount = TryCount(inputTryCount())
    val isMovableFunction = { Random.nextInt(10) >= 4 }
    var racingGame = RacingGame(cars)
    repeat(tryCount.value) {
        racingGame.run(isMovableFunction)
        printCarsStatus(racingGame.cars)
    }
    val winners = racingGame.findWinners()
    printResult(winners)
}
