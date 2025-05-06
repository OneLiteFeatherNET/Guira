package net.onelitefeather.guira.util;

import net.theevilreaper.aves.map.BaseMap;
import net.theevilreaper.aves.map.MapEntry;
import net.onelitefeather.guira.data.BaseSetupData;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public final class NopSetupData extends BaseSetupData<BaseMap> {

    public NopSetupData(@NotNull UUID uuid, @NotNull MapEntry mapEntry) {
        super(uuid, mapEntry);
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
}
