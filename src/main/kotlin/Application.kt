import controller.RacingGame
import model.CarNames
import model.Cars
import model.MovableRule
import model.TryCount
import view.inputCarNames
import view.inputTryCount

fun main() {
    val cars = Cars(CarNames(inputCarNames()))
    val tryCount = TryCount(inputTryCount())
    var racingGame = RacingGame(cars, tryCount)
    racingGame.run(MovableRule.randomMovableRule())
}
