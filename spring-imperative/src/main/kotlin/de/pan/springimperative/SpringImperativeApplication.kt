package de.pan.springimperative

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SpringImperativeApplication

fun main(args: Array<String>) {
	runApplication<SpringImperativeApplication>(*args)
}
