package com.example.clientservice;

import com.example.clientservice.model.Client;
import com.example.clientservice.repository.ClientRepository;
import com.example.clientservice.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client client;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        client = new Client(1L, "John Doe", "john@example.com", "123456789");
    }

    @Test
    public void testCreateClient() {
        // Given
        when(clientRepository.save(client)).thenReturn(client);

        // When
        Client createdClient = clientService.createClient(client);

        // Then
        assertNotNull(createdClient);
        assertEquals(client.getName(), createdClient.getName());
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    public void testGetAllClients() {
        // Given
        when(clientRepository.findAll()).thenReturn(List.of(client));

        // When
        List<Client> clients = clientService.getAllClients();

        // Then
        assertNotNull(clients);
        assertEquals(1, clients.size());
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    public void testGetClientById() {
        // Given
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        // When
        Optional<Client> foundClient = clientService.getClientById(1L);

        // Then
        assertTrue(foundClient.isPresent());
        assertEquals(client.getName(), foundClient.get().getName());
        verify(clientRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdateClient() {
        // Given
        client.setEmail("updated@example.com");
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        when(clientRepository.save(client)).thenReturn(client);

        // When
        Client updatedClient = clientService.updateClient(1L, client);

        // Then
        assertEquals("updated@example.com", updatedClient.getEmail());
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    public void testDeleteClient() {
        // Given
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        // When
        clientService.deleteClient(1L);

        // Then
        verify(clientRepository, times(1)).deleteById(1L);
    }
}
