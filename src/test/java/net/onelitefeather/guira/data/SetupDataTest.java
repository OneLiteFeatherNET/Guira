package net.onelitefeather.guira.data;

import net.onelitefeather.guira.util.NopSetupData;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SetupDataTest {

    @Test
    void testBasicSetupData() {
        UUID uuid = UUID.randomUUID();
        SetupData setupData = new NopSetupData(uuid);
        assertNotNull(setupData);
        assertEquals(uuid, setupData.getId());
        assertInstanceOf(NopSetupData.class, setupData);
    }

    @Test
    void testNopOperations() {
        UUID uuid = UUID.randomUUID();

        SetupData setupData = new NopSetupData(uuid);
        assertNotNull(setupData);
        assertAll(
                "test nop operations",
                () -> assertThrows(UnsupportedOperationException.class, setupData::save),
                () -> assertThrows(UnsupportedOperationException.class, setupData::reset),
                () -> assertThrows(UnsupportedOperationException.class, setupData::loadData)
        );
    }
}
