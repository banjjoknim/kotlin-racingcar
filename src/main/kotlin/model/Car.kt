package model

class Car(val carName: CarName, var position: Position = Position(CAR_INITIAL_POSITION)) {

    fun move(isMovableFunction: () -> Boolean) {
        if (isMovableFunction.invoke()) {
            this.position = position.plus(CAR_MOVE_POSITION_VALUE)
        }
    }

    companion object {
        const val CAR_INITIAL_POSITION = 0
        const val CAR_MOVE_POSITION_VALUE = 1
    }
}
