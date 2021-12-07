package de.pan.springimperative.repository

import de.pan.springimperative.api.entity.AuthorizationEntitlement
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(value = "authentication", url = "http://localhost:8090/api/")
interface AuthenticationService {
    @RequestMapping(method = [RequestMethod.GET], value = ["/authentication"])
    fun authenticate(): AuthorizationEntitlement
}