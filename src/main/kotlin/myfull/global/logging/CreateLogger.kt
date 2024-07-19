package myfull.global.logging

import io.github.oshai.kotlinlogging.KotlinLogging

/**
 * 람다 함수를 통해 클래스 이름을 가져와 로거 인스턴스를 생성한다
 */
fun createLogger(func: () -> Unit) = KotlinLogging.logger(func)
