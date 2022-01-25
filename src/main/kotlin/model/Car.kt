package model

import kotlin.random.Random

private const val MAX_RANDOM_VALUE = 10
private const val CAR_MOVABLE_MIN_VALUE = 4

fun randomMovableFunction(): () -> Boolean = { Random.nextInt(MAX_RANDOM_VALUE) >= CAR_MOVABLE_MIN_VALUE }

class Car(val carName: CarName, var position: Position = Position(CAR_INITIAL_POSITION)) {

    fun move(isMovableFunction: () -> Boolean) {
        if (isMovableFunction.invoke()) {
            this.position = position.plus(CAR_MOVE_POSITION_VALUE)
        }
    }

    fun isIn(position: Position): Boolean {
        return this.position == position
    }

    companion object {
        private const val CAR_INITIAL_POSITION = 0
        private const val CAR_MOVE_POSITION_VALUE = 1
    }
}
