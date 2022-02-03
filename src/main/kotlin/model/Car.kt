package model

class Car(val carName: CarName, var position: Position = Position(CAR_INITIAL_POSITION)) {

    fun move(isMovableFunction: () -> Boolean) {
        if (isMovableFunction.invoke()) {
            this.position = position.plus(CAR_MOVE_POSITION_VALUE)
        }
    }

    fun isIn(position: Position): Boolean {
        return this.position == position
    }

    fun createRecord(): CarRecord {
        return CarRecord(this.carName, this.position)
    }

    companion object {
        private const val CAR_INITIAL_POSITION = 0
        private const val CAR_MOVE_POSITION_VALUE = 1
    }
}
