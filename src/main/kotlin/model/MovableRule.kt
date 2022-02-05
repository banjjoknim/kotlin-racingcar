package model

import kotlin.random.Random

class MovableRule {
    companion object {
        private const val MAX_RANDOM_VALUE = 10
        private const val CAR_MOVABLE_MIN_VALUE = 4

        fun randomMovableRule(): () -> Boolean = { Random.nextInt(MAX_RANDOM_VALUE) >= CAR_MOVABLE_MIN_VALUE }
    }
}
