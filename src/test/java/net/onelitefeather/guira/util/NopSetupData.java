package net.onelitefeather.guira.util;

import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public final class NopSetupData implements SetupData {

    private final UUID uuid;

    public NopSetupData(@NotNull UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void loadData() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public @NotNull UUID getId() {
        return this.uuid;
    }
}
