package model

class Cars(private val _cars: List<Car>) {
    constructor(carNames: CarNames) : this(
        carNames.toList()
            .map(::Car)
    )

    fun race(movableFunction: () -> Boolean) {
        _cars.forEach { car -> car.move(movableFunction) }
    }

    val cars: List<Car>
        get() = ArrayList(_cars)
}
