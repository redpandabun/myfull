package myfull.global.logging

import kotlin.test.Test
import kotlin.test.assertEquals

internal class CreateLoggerTest {


  @Test
  fun `createLogger 메소드는 올바른 클래스 이름을 반환해야 한다`() {
    assertEquals(CreateLoggerTest::class.qualifiedName, createLogger {}.name)
  }
}
