package com.example.clientservice.service;

import com.example.clientservice.model.Client;
import com.example.clientservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> getClientsByName(String name) {
        return clientRepository.findByNameContainingIgnoreCase(name);
    }

    public Client updateClient(Long id, Client updatedClient) {
        Optional<Client> existingClient = clientRepository.findById(id);
        if (existingClient.isPresent()) {
            Client client = existingClient.get();
            // Update fields with the new data from updatedClient
            client.setName(updatedClient.getName());
            client.setEmail(updatedClient.getEmail());
            client.setPhoneNumber(updatedClient.getPhoneNumber());
            return clientRepository.save(client);  // Save the updated client
        } else {
            return null;  // Return null if client is not found
        }
    }
}
