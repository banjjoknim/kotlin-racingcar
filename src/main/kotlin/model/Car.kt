package model

import controller.model.MoveStrategy
import controller.model.Position

class Car(val carName: CarName, var position: Position = Position(CAR_INITIAL_POSITION)) {

    fun move(moveStrategy: MoveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position = position.plus(CAR_MOVE_POSITION_VALUE)
        }
    }

    companion object {
        const val CAR_INITIAL_POSITION = 0
        const val CAR_MOVE_POSITION_VALUE = 1
    }
}
