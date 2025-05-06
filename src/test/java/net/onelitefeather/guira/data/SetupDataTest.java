package net.onelitefeather.guira.data;

import net.theevilreaper.aves.map.BaseMap;
import net.onelitefeather.guira.BasicDataTest;
import net.onelitefeather.guira.util.NopSetupData;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SetupDataTest extends BasicDataTest {

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
