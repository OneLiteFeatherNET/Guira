package net.onelitefeather.guira;

import de.icevizion.aves.map.MapEntry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public abstract class BasicDataTest {

    protected static Path tempDir;
    protected static MapEntry emptyMapEntry;

    @BeforeAll
    static void beforeAll() throws URISyntaxException {
        tempDir = Paths.get(BasicDataTest.class.getResource("/emptyFolder").toURI());
        assertNotNull(tempDir, "The test class for the SetupData requires a folder with the name 'emptyFolder'");
        emptyMapEntry = MapEntry.of(tempDir);
        assertFalse(emptyMapEntry.hasMapFile(), "The emptyFolder for the test should not contain any files!");
    }

    @AfterAll
    static void afterAll() {
        tempDir = null;
        emptyMapEntry = null;
    }
}
