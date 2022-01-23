package model

import controller.model.Position
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class PositionTest {

    @DisplayName("위치는")
    @Nested
    inner class CreateTests {

        @Test
        fun `입력값이 0일 경우 정상적으로 생성된다`() {
            // given
            val value = 0

            // when
            val position = Position(value)

            // then
            assertThat(position.value).isEqualTo(0)
        }

        @Test
        fun `입력값이 양수일 경우 정상적으로 생성된다`() {
            // given
            val value = 1

            // when
            val position = Position(value)

            // then
            assertThat(position.value).isEqualTo(1)
        }

        @Test
        fun `입력값이 음수일 경우 예외가 발생한다`() {
            // given
            val value = -1

            // when

            // then
            assertThrows<IllegalArgumentException> { Position(value) }
        }
    }

    @DisplayName("위치는 더할 시")
    @Nested
    inner class PlusTests {

        @Test
        fun `더한 값 만큼 값이 증가한 새로운 위치를 만든다`() {
            // given
            val value = 1
            val position = Position(0)

            // when
            val actual = position.plus(value)

            // then
            assertAll(
                { assertThat(position).isNotEqualTo(actual) },
                { assertThat(actual.value).isEqualTo(1) }
            )
        }
    }
}
