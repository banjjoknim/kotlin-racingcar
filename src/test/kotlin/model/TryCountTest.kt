package model

import controller.model.TryCount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TryCountTest {

    @DisplayName("시도 횟수가")
    @Nested
    inner class TryCountTests {

        @Test
        fun `0보다 큰 양수이면 정상적으로 생성된다`() {
            // given
            val value = 1

            // when
            val actual = TryCount(value)

            // then
            assertThat(actual.value).isEqualTo(1)
        }

        @Test
        fun `음수이면 예외가 발생한다`() {
            // given
            val value = -1

            // when

            // then
            assertThrows<IllegalArgumentException> { TryCount(value) }
        }

        @Test
        fun `0이면 예외가 발생한다`() {
            // given
            val value = 0

            // when

            // then
            assertThrows<IllegalArgumentException> { TryCount(value) }
        }
    }
}
