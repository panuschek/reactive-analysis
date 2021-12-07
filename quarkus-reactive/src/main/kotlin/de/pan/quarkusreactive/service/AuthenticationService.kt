package de.pan.quarkusreactive.service

import de.pan.quarkusreactive.api.entity.AuthorizationEntitlement
import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/authentication")
@RegisterRestClient
interface AuthenticationService {
    @GET
    fun authenticate(): Uni<AuthorizationEntitlement>
}