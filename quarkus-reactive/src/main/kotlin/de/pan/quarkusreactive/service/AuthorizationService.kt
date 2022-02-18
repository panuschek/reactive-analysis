package de.pan.quarkusreactive.service

import de.pan.quarkusreactive.api.entity.AuthorizationEntitlement
import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.HeaderParam
import javax.ws.rs.Path

@Path("/auth")
@RegisterRestClient(configKey = "authentication-api")
interface AuthorizationService {
    @GET
    fun auth(@HeaderParam("Authorization") authToken: String): Uni<AuthorizationEntitlement>
}