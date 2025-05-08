package com.stackdev.repositories

import com.stackdev.models.ClientDetails
import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import java.util.Optional

@ApplicationScoped
class ClientDetailsRepository: PanacheRepository<ClientDetails> {
    fun findByNameOptional(name: String): Optional<ClientDetails> = find("name", name).firstResultOptional<ClientDetails>()
}
