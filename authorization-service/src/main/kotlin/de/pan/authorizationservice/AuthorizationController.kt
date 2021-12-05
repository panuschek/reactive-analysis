package de.pan.authorizationservice

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class AuthenticationController {
    @PostMapping("authentication")
    fun authorizationEntitlement(): AuthorizationEntitlement {
        return AuthorizationEntitlement(listOf(), listOf())
    }
}