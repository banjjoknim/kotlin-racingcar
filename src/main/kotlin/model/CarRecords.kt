package model

data class CarRecords(val carRecords: Map<Int, List<CarRecord>>) {
    val size = this.carRecords.size

    fun getCarRecords(count: Int): List<CarRecord> {
        return this.carRecords[count] ?: throw NoSuchElementException("can not found records. count: $count")
    }
}
