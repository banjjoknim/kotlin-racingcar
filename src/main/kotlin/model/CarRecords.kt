package model

data class CarRecords(private val _carRecords: Map<Int, List<CarRecord>>) {
    val carRecords = _carRecords.toSortedMap().values
}
