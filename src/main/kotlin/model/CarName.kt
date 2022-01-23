package model

data class CarName(val value: String) {

    init {
        require(value.isNotBlank()) { "car name value can not be blank. value: $value" }
        require(value.length <= NAME_LENGTH_LIMIT) { "car name value length should less than $NAME_LENGTH_LIMIT. value: $value" }
    }

    companion object {
        private const val NAME_LENGTH_LIMIT = 5
    }
}
