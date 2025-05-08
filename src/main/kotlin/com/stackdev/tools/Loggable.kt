package com.stackdev.tools

import mu.KLogger
import mu.KotlinLogging

interface Loggable {
    val log: KLogger
        get() = KotlinLogging.logger(this::class.java.name)
}
