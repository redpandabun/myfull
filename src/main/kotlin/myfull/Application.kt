package myfull

import myfull.global.logging.createLogger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener
import kotlin.time.DurationUnit.MILLISECONDS
import kotlin.time.toKotlinDuration

@SpringBootApplication
class Application {
  private final val log = createLogger {}

  @EventListener
  fun onReady(e: ApplicationReadyEvent) {
    val startedAt = e.timeTaken.toKotlinDuration().toString(MILLISECONDS)

    log.info { "Application started at $startedAt" }
  }
}

fun main(vararg args: String) {
  runApplication<Application>(*args)
}
