package model

data class TryCount(val value: Int) {

    init {
        require(value > TRY_COUNT_MIN_LIMIT) { "TryCount value can not be zero or negative. value: $value" }
    }

    companion object {
        const val TRY_COUNT_MIN_LIMIT = 0
    }
}
