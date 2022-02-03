package model

class Cars(private val _cars: List<Car>) {
    constructor(carNames: CarNames) : this(
        carNames.toList()
            .map(::Car)
    )

    fun race(tryCount: TryCount, movableFunction: () -> Boolean): Map<Int, List<CarRecord>> {
        val carRecords = mutableMapOf<Int, List<CarRecord>>()
        repeat(tryCount.value) { count ->
            _cars.forEach { car -> car.move(movableFunction) }
            carRecords[count] = _cars.createRecords()
        }
        return carRecords
    }

    private fun List<Car>.createRecords(): List<CarRecord> {
        return this.map { car -> car.createRecord() }
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
