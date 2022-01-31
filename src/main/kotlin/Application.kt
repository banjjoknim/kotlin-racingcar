import controller.RacingGame
import model.CarNames
import model.Cars
import model.TryCount
import model.randomMovableFunction
import view.inputCarNames
import view.inputTryCount

fun main() {
    val cars = Cars(CarNames(inputCarNames()))
    val tryCount = TryCount(inputTryCount())
    var racingGame = RacingGame(cars, tryCount)
    racingGame.run(randomMovableFunction())
}
