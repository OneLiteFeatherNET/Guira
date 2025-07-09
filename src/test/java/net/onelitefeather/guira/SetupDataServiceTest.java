package net.onelitefeather.guira;

import net.onelitefeather.guira.data.SetupData;
import net.onelitefeather.guira.util.NopSetupData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SetupDataServiceTest {

    private static SetupDataService service;

    @BeforeAll
    static void setup() {
        service = SetupDataService.create();

        assertNotNull(service, "SetupDataService should not be null after creation");
        assertTrue(service.isEmpty(), "SetupDataService should be empty after creation");
    }

    @AfterEach
    void tearDown() {
        service.clear();
    }

    @BeforeEach
    void beforeEach() {
        assertTrue(service.isEmpty(), "SetupDataService should be empty after creation");
    }

    @Test
    void testSetupDataAdd() {
        UUID owner = UUID.randomUUID();
        SetupData data = new NopSetupData(owner);

        service.add(owner, data);

        assertFalse(service.isEmpty(), "SetupDataService should not be empty after adding data");

        Optional<SetupData> retrievedData = service.get(owner);

        assertTrue(retrievedData.isPresent(), "SetupData should be present after adding");

        SetupData fetchedData = retrievedData.get();
        assertEquals(owner, fetchedData.getId(), "Fetched SetupData owner should match the added owner");
        assertInstanceOf(NopSetupData.class, fetchedData, "Fetched SetupData should be an instance of NopSetupData");
    }

    @Test
    void testSetupDataRemove() {
        UUID owner = UUID.randomUUID();
        SetupData data = new NopSetupData(owner);

        service.add(owner, data);
        assertFalse(service.isEmpty(), "SetupDataService should not be empty after adding data");

        service.remove(owner);
        assertTrue(service.isEmpty(), "SetupDataService should be empty after removing data");

        Optional<SetupData> retrievedData = service.get(owner);
        assertFalse(retrievedData.isPresent(), "SetupData should not be present after removal");

        assertTrue(service.remove(UUID.randomUUID()).isEmpty(),
                "Removing a non-existent SetupData should return an empty Optional");
    }
}