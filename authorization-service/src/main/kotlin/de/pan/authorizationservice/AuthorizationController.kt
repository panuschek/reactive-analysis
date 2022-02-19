package de.pan.authorizationservice

import com.auth0.jwt.JWT
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class AuthorizationController {
    private val log = LoggerFactory.getLogger(AuthorizationController::class.java)

    @GetMapping("auth")
    fun authentication(@RequestHeader("Authorization") authHeader: String): AuthorizationEntitlement {
        val jwt = JWT.decode(authHeader.replace("Bearer ", ""))
        val rolesInGroup = jwt.getClaim("groups").asArray(Number::class.java)

        Thread.sleep(5000)
        return AuthorizationEntitlement(rolesInGroup)
    }
}