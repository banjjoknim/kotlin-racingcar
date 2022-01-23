package controller.model

data class Position(val value: Int) {
    fun plus(value: Int): Position {
        return Position(this.value.plus(value))
    }

    init {
        require(value >= POSITION_MIN_VALUE) { "position should greater than $POSITION_MIN_VALUE or equal. value: $value" }
    }

    companion object {
        const val POSITION_MIN_VALUE = 0
    }
}
