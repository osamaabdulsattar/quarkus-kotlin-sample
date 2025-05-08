package com.stackdev.service

import com.stackdev.models.ClientDetails
import com.stackdev.repositories.ClientDetailsRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class ClientDetailsService {

    @Inject
    private lateinit var clientDetailsRepository: ClientDetailsRepository

    fun saveClient(clientDetails: ClientDetails) {
        clientDetailsRepository.persist(clientDetails)
    }

    fun findAll(): List<ClientDetails> {
        return clientDetailsRepository.listAll()
    }

    fun findById(id: Long): ClientDetails? {
        return clientDetailsRepository.findByIdOptional(id).orElse(null)
    }

    fun findByName(name: String): ClientDetails? {
        return clientDetailsRepository.findByNameOptional(name).orElse(null)
    }

    fun deleteById(id: Long) {
        clientDetailsRepository.deleteById(id)
    }

    fun updateClientDetails(clientDetails: ClientDetails) {
        clientDetails.id?.let { findById(it) }
        clientDetailsRepository.update("" +
                "name=${clientDetails.name} " +
                "surname=${clientDetails.surname} " +
                "age=${clientDetails.age} " +
                "email=${clientDetails.email} " +
                "basicSalary=${clientDetails.basicSalary} " +

                "where id=${clientDetails.id}", clientDetails)
    }
}
