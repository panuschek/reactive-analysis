package de.pan.springimperative.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(value = "webservice", url = "http://\${webservice.url}/api/")
interface WebService {
    @RequestMapping(method = [RequestMethod.GET], value = ["/dummy"])
    fun request(): String
}