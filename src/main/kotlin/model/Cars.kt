package model

class Cars(private val _cars: List<Car>) {

    constructor(carNames: CarNames) : this(
        carNames.toList()
            .map(::Car)
    )

    val cars: List<Car>
        get() = ArrayList(_cars)
}
