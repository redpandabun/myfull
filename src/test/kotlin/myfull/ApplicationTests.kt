package myfull

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import kotlin.test.Test
import kotlin.test.assertNotNull

@SpringBootTest
class ApplicationTests {
  @Test
  fun contextLoads(ctx: ApplicationContext) {
    assertNotNull(ctx.id)
  }
}
