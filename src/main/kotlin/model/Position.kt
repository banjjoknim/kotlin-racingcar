package model

data class Position(val value: Int) : Comparable<Position> {
    fun plus(value: Int): Position {
        return Position(this.value.plus(value))
    }

    init {
        require(value >= POSITION_MIN_VALUE) { "position should greater than $POSITION_MIN_VALUE or equal. value: $value" }
    }

    override fun compareTo(other: Position): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        const val POSITION_MIN_VALUE = 0
    }
}
