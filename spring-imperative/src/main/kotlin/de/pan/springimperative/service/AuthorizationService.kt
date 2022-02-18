package de.pan.springimperative.service

import de.pan.springimperative.api.entity.AuthorizationEntitlement
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(value = "authorization", url = "http://localhost:8090/api/")
interface AuthorizationService {
    @RequestMapping(method = [RequestMethod.GET], value = ["/auth"])
    fun auth(@RequestHeader("Authorization") authorization: String): AuthorizationEntitlement
}