package model

class Car(val carName: CarName, val position: Int = CAR_INITIAL_POSITION) {
    companion object {
        const val CAR_INITIAL_POSITION = 0
    }
}
