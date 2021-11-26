package de.pan.micronautreactive

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("de.pan.micronautreactive")
		.start()
}

