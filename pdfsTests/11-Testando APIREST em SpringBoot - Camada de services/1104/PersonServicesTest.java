package br.com.erudio.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Optional;

import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

    @Mock
    private PersonRepository repository;
    
    @InjectMocks
    private PersonServices services;

    private Person person0;
    
    @BeforeEach
    public void setup() {
        // Given / Arrange
        person0 = new Person(
            "Leandro",
            "Costa",
            "leandro@erudio.com.br",
            "Uberlândia - Minas Gerais - Brasil",
            "Male");
    }
    
    @DisplayName("JUnit test for Given Person Object when Save Person then Return Person Object")
    @Test
    void testGivenPersonObject_WhenSavePerson_thenReturnPersonObject() {
        
        // Given / Arrange
        given(repository.findByEmail(anyString())).willReturn(Optional.empty());
        given(repository.save(person0)).willReturn(person0);
        
        // When / Act
        Person savedPerson = services.create(person0);
        
        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals("Leandro", savedPerson.getFirstName());
    }   
    
    @DisplayName("JUnit test for Given Existing Email when Save Person then throws Exception")
    @Test
    void testGivenExistingEmail_WhenSavePerson_thenThrowsException() {
        
        // Given / Arrange
        given(repository.findByEmail(anyString())).willReturn(Optional.of(person0));
        
        // When / Act
        assertThrows(ResourceNotFoundException.class, () -> {
            services.create(person0);
        });
        
        // Then / Assert
        verify(repository, never()).save(any(Person.class));
    }   
}
