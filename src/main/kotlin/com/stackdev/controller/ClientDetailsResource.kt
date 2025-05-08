package com.stackdev.controller

import com.stackdev.models.ClientDetails
import com.stackdev.service.ClientDetailsService
import com.stackdev.tools.Loggable
import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/api/clients")
class ClientDetailsResource : Loggable {

    @Inject
    lateinit var clientDetailsService: ClientDetailsService

    @GET()
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    fun findAll(): Response {
        return Response.ok(clientDetailsService.findAll()).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findById(@PathParam("id") id: Long): Response {
        val clientDetails = clientDetailsService.findById(id)
        if (clientDetails == null) {
            return Response.ok("Client not found").status(Response.Status.NOT_FOUND).build()
        }
        return Response.ok(clientDetails).build()
    }

    @GET
    @Path("/byname")
    @Produces(MediaType.APPLICATION_JSON)
    fun findByName(@QueryParam("name") name: String): Response {
        log.info { "sear by name:${name}" }
        return Response.ok(clientDetailsService.findByName(name)).build()
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun saveClientDetails(clientDetails: ClientDetails): Response {
        return Response.ok(clientDetailsService.saveClient(clientDetails)).status(Response.Status.CREATED).build()
    }

    @PUT
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun updateClientDetails(clientDetails: ClientDetails): Response {
        return Response.ok(clientDetailsService.updateClientDetails(clientDetails)).status(Response.Status.OK).build()
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteClientDetails(@PathParam("id") id: Long): Response {
        val clientDetails = clientDetailsService.findById(id)
        if (clientDetails == null) {
            return Response.ok("Client not found").status(Response.Status.NOT_FOUND).build()
        }
        clientDetailsService.deleteById(id)
        return Response.status(Response.Status.OK).build()
    }
}
