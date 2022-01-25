package model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class CarsTest {

    @DisplayName("자동차들이 경주를 할 때")
    @Nested
    inner class RaceCases {

        private lateinit var cars: Cars

        @BeforeEach
        fun setUp() {
            cars = Cars(listOf(Car(CarName("one")), Car(CarName("two")), Car(CarName("three"))))
        }

        @Test
        fun `이동 가능한 상태가 주어진 모든 자동차가 이동한다`() {
            // given
            val isMovableFunction = { true }

            // when
            cars.race(isMovableFunction)

            // then
            assertAll(
                { Assertions.assertThat(cars.cars[0].position.value).isEqualTo(1) },
                { Assertions.assertThat(cars.cars[1].position.value).isEqualTo(1) },
                { Assertions.assertThat(cars.cars[2].position.value).isEqualTo(1) }
            )
        }

        @Test
        fun `이동 가능한 상태가 주어지지 않은 모든 자동차가 이동하지 않는다`() {
            // given
            val isMovableFunction = { false }

            // when
            cars.race(isMovableFunction)

            // then
            assertAll(
                { Assertions.assertThat(cars.cars[0].position.value).isEqualTo(0) },
                { Assertions.assertThat(cars.cars[1].position.value).isEqualTo(0) },
                { Assertions.assertThat(cars.cars[2].position.value).isEqualTo(0) }
            )
        }
    }
}
