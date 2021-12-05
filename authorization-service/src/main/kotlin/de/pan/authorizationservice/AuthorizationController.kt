package de.pan.authorizationservice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class AuthorizationController {
    @GetMapping("authentication")
    fun authorizationEntitlement(): ResponseEntity<String> {
        Thread.sleep(75)
        return ResponseEntity.ok("Ok")
    }
}