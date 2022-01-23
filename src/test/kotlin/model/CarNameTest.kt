package model

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarNameTest {

    @DisplayName("자동차의 이름이")
    @Nested
    inner class CarNameTest {

        @Test
        fun `5글자 이내이면 정상적으로 생성된다`() {
            // given
            val carName = "12345"

            // when

            // then
            assertDoesNotThrow { CarName(carName) }
        }

        @Test
        fun `5글자를 초과할 경우 예외가 발생한다`() {
            // given
            val carName = "123456"

            // when

            // then
            assertThrows<IllegalArgumentException> { CarName(carName) }
        }

        @Test
        fun `공백일 경우 예외가 발생한다`() {
            // given
            val carName = ""

            // when

            // then
            assertThrows<IllegalArgumentException> { CarName(carName) }
        }
    }
}
