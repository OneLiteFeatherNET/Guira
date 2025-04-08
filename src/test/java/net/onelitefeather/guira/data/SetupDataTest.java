package net.onelitefeather.guira.data;

import de.icevizion.aves.map.BaseMap;
import de.icevizion.aves.map.MapEntry;
import net.onelitefeather.guira.util.NopSetupData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SetupDataTest {

    private static Path tempDir;
    private static MapEntry emptyMapEntry;

    @BeforeAll
    static void beforeAll() throws URISyntaxException {
        tempDir = Paths.get(SetupDataTest.class.getResource("/emptyFolder").toURI());
        assertNotNull(tempDir, "The test class for the SetupData requires a folder with the name 'emptyFolder'");
        emptyMapEntry = MapEntry.of(tempDir);
        assertFalse(emptyMapEntry.hasMapFile(), "The emptyFolder for the test should not contain any files!");
    }

    @AfterAll
    static void afterAll() {
        tempDir = null;
        emptyMapEntry = null;
    }

    @Test
    void testBasicSetupData() {
        UUID uuid = UUID.randomUUID();
        SetupData<BaseMap> setupData = new NopSetupData(uuid, emptyMapEntry);
        assertNotNull(setupData);
        assertEquals(uuid, setupData.getId());
        assertEquals(emptyMapEntry, setupData.getEntry());
        assertInstanceOf(NopSetupData.class, setupData);
        assertFalse(setupData.hasMapFile());
        assertTrue(setupData.getMap().isEmpty());
    }

    @Test
    void testNopOperations() {
        UUID uuid = UUID.randomUUID();

        SetupData<BaseMap> setupData = new NopSetupData(uuid, emptyMapEntry);
        assertNotNull(setupData);
        assertAll(
                "test nop operations",
                () -> assertThrows(UnsupportedOperationException.class, setupData::save),
                () -> assertThrows(UnsupportedOperationException.class, setupData::reset),
                () -> assertThrows(UnsupportedOperationException.class, setupData::loadData)
        );
    }
}
