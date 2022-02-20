package de.pan.webservice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class WebServiceController {
    @GetMapping("dummy")
    fun getCall(): ResponseEntity<String> {
        Thread.sleep(300)
        return ResponseEntity.ok("ok")
    }
}