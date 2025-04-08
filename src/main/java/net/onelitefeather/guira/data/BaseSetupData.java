package net.onelitefeather.guira.data;

import de.icevizion.aves.map.BaseMap;
import de.icevizion.aves.map.MapEntry;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public abstract non-sealed class BaseSetupData<T extends BaseMap> implements SetupData<T> {

    protected final UUID uuid;
    protected final MapEntry mapEntry;
    protected T map;

    protected BaseSetupData(@NotNull UUID uuid, @NotNull MapEntry mapEntry) {
        this.uuid = uuid;
        this.mapEntry = mapEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BaseSetupData<?> that)) return false;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    @Override
    public boolean hasMapFile() {
        return this.mapEntry.hasMapFile();
    }

    @Override
    public @NotNull MapEntry getEntry() {
        return this.mapEntry;
    }

    @Override
    public @NotNull UUID getId() {
        return this.uuid;
    }

    @Override
    public @NotNull Optional<T> getMap() {
        return Optional.ofNullable(this.map);
    }
}
