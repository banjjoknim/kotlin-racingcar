package controller.model

data class TryCount(val tryCount: Int) {

    init {
        require(tryCount > TRY_COUNT_MIN_LIMIT)
    }

    companion object {
        const val TRY_COUNT_MIN_LIMIT = 0
    }
}
