package net.onelitefeather.guira.event;

import net.theevilreaper.aves.map.BaseMap;
import net.onelitefeather.guira.BasicDataTest;
import net.onelitefeather.guira.data.SetupData;
import net.onelitefeather.guira.util.NopSetupData;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SetupFinishEventTest extends BasicDataTest {

    @Test
    void testEventConstruction() {
        UUID uuid = UUID.randomUUID();
        SetupData<BaseMap> data = new NopSetupData(uuid, emptyMapEntry);
        SetupFinishEvent<SetupData<BaseMap>> event = new SetupFinishEvent<>(data);
        assertNotNull(event);
        assertInstanceOf(NopSetupData.class, event.getData());

        assertFalse(event.isCancelled());
        event.setCancelled(true);
        assertTrue(event.isCancelled());
    }
}
