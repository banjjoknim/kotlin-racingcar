package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CarTest {

    @DisplayName("자동차의 생성시")
    @Nested
    inner class CreateCaseTests {

        @Test
        fun `기본적으로 최초 위치가 0이다`() {
            // given
            val car = Car(CarName("car"))

            // when

            // then
            assertThat(car.position.value).isEqualTo(0)
        }

        @Test
        fun `위치를 지정해줄 수 있다`() {
            // given
            val car = Car(CarName("car"), Position(3))

            // when

            // then
            assertThat(car.position.value).isEqualTo(3)
        }
    }

    @DisplayName("자동차의 이동시")
    @Nested
    inner class MoveTestCases {

        private lateinit var car: Car

        @BeforeEach
        fun setup() {
            car = Car(CarName("car"))
        }

        @Test
        fun `이동 가능한 상태이면 위치가 1 증가한다`() {
            // given
            fun isMovable() = true

            // when
            car.move { isMovable() }

            // then
            assertThat(car.position.value).isEqualTo(1)
        }

        @Test
        fun `이동 가능한 상태가 아니면 위치가 변하지 않는다`() {
            // given
            fun isMovable() = false

            // when
            car.move { isMovable() }

            // then
            assertThat(car.position.value).isEqualTo(0)
        }
    }

    @DisplayName("자동차의 위치가")
    @Nested
    inner class IsInTestCases {

        private val car = Car(CarName("car"), Position(1))

        @Test
        fun `입력으로 주어진 위치와 동일하면 참을 반환한다`() {
            // given
            val position = Position(1)

            // when
            val actual = car.isIn(position)

            // then
            assertThat(actual).isTrue
        }

        @Test
        fun `입력으로 주어진 위치와 동일하지 않으면 거짓을 반환한다`() {
            // given
            val position = Position(0)

            // when
            val actual = car.isIn(position)

            // then
            assertThat(actual).isFalse
        }
    }

    @DisplayName("자동차의 기록은")
    @Nested
    inner class CreateRecordTestCases {

        private val car = Car(CarName("car"), Position(1))

        @Test
        fun `자동차의 현재 상태를 그대로 가진다`() {
            // given

            // when
            val carRecord = car.createRecord()

            // then
            assertThat(carRecord).isEqualTo(CarRecord(CarName("car"), Position(1)))
        }
    }
}
