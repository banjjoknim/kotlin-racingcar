package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CarTest {

    @DisplayName("자동차는")
    @Nested
    inner class CarTests {

        @Test
        fun `생성시 최초 위치가 0이다`() {
            // given
            val carName = CarName("car")

            // when
            val car = Car(carName)

            // then
            assertThat(car.position).isEqualTo(0)
        }
    }
}
