package de.pan.quarkusreactive.service

import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/api/dummy")
@RegisterRestClient(configKey = "webservice")
interface WebService {
    @GET
    fun request(): Uni<String>
}