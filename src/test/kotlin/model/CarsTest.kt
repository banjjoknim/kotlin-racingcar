package model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class CarsTest {

    @DisplayName("자동차들이 경주를 할 때")
    @Nested
    inner class RaceTestCases {

        private lateinit var cars: Cars

        @BeforeEach
        fun setUp() {
            cars = Cars(listOf(Car(CarName("one")), Car(CarName("two")), Car(CarName("three"))))
        }

        @Test
        fun `이동 가능한 상태가 주어진 모든 자동차가 이동한다`() {
            // given
            val tryCount = TryCount(1)
            val isMovableFunction = { true }

            // when
            cars.race(tryCount, isMovableFunction)

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
            val tryCount = TryCount(1)
            val isMovableFunction = { false }

            // when
            cars.race(tryCount, isMovableFunction)

            // then
            assertAll(
                { Assertions.assertThat(cars.cars[0].position.value).isEqualTo(0) },
                { Assertions.assertThat(cars.cars[1].position.value).isEqualTo(0) },
                { Assertions.assertThat(cars.cars[2].position.value).isEqualTo(0) }
            )
        }
    }

    @DisplayName("우승한 자동차는")
    @Nested
    inner class FindWinnersTestCases {

        private lateinit var cars: Cars

        @Test
        fun `참가자가 없을 경우 찾을 수 없다`() {
            // given
            cars = Cars(listOf())

            // when

            // then
            assertThrows<NoSuchElementException> { cars.findWinners() }
        }

        @Test
        fun `가장 큰 위치 값을 가지고 있다`() {
            // given
            cars = Cars(
                listOf(
                    Car(CarName("one"), Position(3)),
                    Car(CarName("two"), Position(3)),
                    Car(CarName("three"), Position(2))
                )
            )

            // when
            val winners = cars.findWinners()

            // then
            assertThat(winners[0].position).isEqualTo(Position(3))
        }

        @Test
        fun `여럿이 나올 수 있다`() {
            // given
            cars = Cars(listOf(Car(CarName("one")), Car(CarName("two")), Car(CarName("three"))))

            // when
            val winners = cars.findWinners()

            // then
            assertThat(winners).hasSize(3)
        }
    }
}
