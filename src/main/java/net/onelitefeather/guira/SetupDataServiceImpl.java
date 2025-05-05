package net.onelitefeather.guira;

import de.icevizion.aves.map.BaseMap;
import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public final class SetupDataServiceImpl<T extends SetupData<? extends BaseMap>> implements SetupDataService<T> {

    private final Map<UUID, T> dataMap;

    SetupDataServiceImpl() {
        this.dataMap = new HashMap<>();
    }

    @Override
    public void add(@NotNull UUID uuid, @NotNull T data) {
        dataMap.put(uuid, data);
    }

    @Override
    public @NotNull Optional<T> remove(@NotNull UUID uuid) {
        return Optional.ofNullable(this.dataMap.remove(uuid));
    }

    @Override
    public @NotNull Optional<T> get(@NotNull UUID uuid) {
        return Optional.ofNullable(this.dataMap.get(uuid));
    }

    @Override
    public @NotNull @UnmodifiableView Map<UUID, T> getView() {
        return Collections.unmodifiableMap(this.dataMap);
    }
}
