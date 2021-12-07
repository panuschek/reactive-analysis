package de.pan.authorizationservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class AuthorizationController {
    @GetMapping("authentication")
    fun authentication(): AuthorizationEntitlement {
        Thread.sleep(1500)
        return AuthorizationEntitlement("ok")
    }
}