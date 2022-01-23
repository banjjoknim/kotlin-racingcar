package model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class CarNamesTest {

    @DisplayName("입력된 자동차의 이름들이")
    @Nested
    inner class CarNamesTests {

        @Test
        fun `모두 정상이면 리스트로 변환할 수 있다`() {
            // given
            val inputCarNames = "one,two,three"

            // when
            val carNames = CarNames(inputCarNames)
            val actual = carNames.toList()

            // then
            assertAll(
                { Assertions.assertThat(actual).hasSize(3) },
                { Assertions.assertThat(actual).containsAll(listOf(CarName("one"), CarName("two"), CarName("three"))) },
            )
        }
    }
}
