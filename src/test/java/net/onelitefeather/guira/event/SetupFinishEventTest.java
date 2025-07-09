package net.onelitefeather.guira.event;

import net.onelitefeather.guira.data.SetupData;
import net.onelitefeather.guira.util.NopSetupData;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SetupFinishEventTest {

    @Test
    void testEventConstruction() {
        UUID uuid = UUID.randomUUID();
        SetupData data = new NopSetupData(uuid);
        SetupFinishEvent event = new SetupFinishEvent(data);
        assertNotNull(event);
        assertInstanceOf(NopSetupData.class, event.getData());

        assertFalse(event.isCancelled());
        event.setCancelled(true);
        assertTrue(event.isCancelled());
    }
}
