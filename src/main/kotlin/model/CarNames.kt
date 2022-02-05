package model

data class CarNames(val inputCarNames: String) {

    fun toList(): List<CarName> {
        return this.inputCarNames.split(DELIMITER).map(::CarName)
    }

    companion object {
        const val DELIMITER = ","
    }
}
