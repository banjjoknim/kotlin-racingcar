package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarRecordsTest {

    @DisplayName("자동차의 기록들은")
    @Nested
    inner class CarRecordsTestCases {

        @Test
        fun `시도 횟수만큼의 크기를 가진다`() {
            // given
            val carRecords = CarRecords(mapOf(1 to listOf(CarRecord(CarName("car"), Position(1)))))

            // when
            val actual = carRecords.size

            // then
            assertThat(actual).isEqualTo(1)
        }

        @Test
        fun `존재하지 않는 기록에 대해 조회할 경우 예외가 발생한다`() {
            // given
            val carRecords = CarRecords(emptyMap())

            // when

            // then
            assertThrows<NoSuchElementException> { carRecords.getCarRecords(1) }
        }
    }
}
