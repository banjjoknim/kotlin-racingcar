package model

class Cars(private val _cars: List<Car>) {
    constructor(carNames: CarNames) : this(
        carNames.toList()
            .map(::Car)
    )

    fun race(movableFunction: () -> Boolean) {
        _cars.forEach { car -> car.move(movableFunction) }
    }

    fun findWinners(): List<Car> {
        val maxPosition = maxPosition()
        return this._cars.filter { car -> car.isIn(maxPosition) }
    }

    private fun maxPosition(): Position {
        return this._cars.map(Car::position).maxByOrNull(Position::value)
            ?: throw NoSuchElementException("there is no element. because cars are empty.")
    }

    val cars: List<Car>
        get() = ArrayList(_cars)
}
