package model

data class CarName(var name: String) {

    init {
        require(name.isNotBlank()) { "자동차의 이름은 null 또는 공백일 수 없습니다." }
        require(name.length <= NAME_LENGTH_LIMIT) { "자동차 이름의 길이는 5글자 이하여야 합니다." }
    }

    companion object {
        private const val NAME_LENGTH_LIMIT = 5
    }
}
