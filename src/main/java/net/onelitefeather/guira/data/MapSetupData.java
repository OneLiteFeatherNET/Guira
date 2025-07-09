package net.onelitefeather.guira.data;

import net.theevilreaper.aves.map.BaseMap;
import net.theevilreaper.aves.map.MapEntry;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * The {@link MapSetupData} is a generic implementation of the {@link SetupData} interface.
 * It provides a basic implementation and needs to be extended by a specific setup data class.
 * @param <T> the reference type of the map
 * @version 1.0.0
 * @since 0.1.0
 * @author theEvilReaper
 */
public abstract class MapSetupData<T extends BaseMap> implements SetupData {

    protected final UUID uuid;
    protected final MapEntry mapEntry;
    protected T map;

    protected MapSetupData(@NotNull UUID uuid, @NotNull MapEntry mapEntry) {
        this.uuid = uuid;
        this.mapEntry = mapEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MapSetupData<?> that)) return false;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    /**
     * Returns if the setup data has a map file.
     *
     * @return {@code true} if the setup data has a map
     */
    public boolean hasMapFile() {
        return this.mapEntry.hasMapFile();
    }

    /**
     * Returns the map entry of the setup data.
     *
     * @return the map entry as {@link MapEntry}
     */
    public @NotNull MapEntry getEntry() {
        return this.mapEntry;
    }

    /**
     * Returns the map of the setup data.
     *
     * @return the map as {@link BaseMap}
     */
    public @NotNull UUID getId() {
        return this.uuid;
    }

    public @NotNull Optional<T> getMap() {
        return Optional.ofNullable(this.map);
    }
}
