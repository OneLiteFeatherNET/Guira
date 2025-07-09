package net.onelitefeather.guira;

import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public final class SetupDataServiceImpl implements SetupDataService {

    private final Map<UUID, SetupData> dataMap;

    SetupDataServiceImpl() {
        this.dataMap = new HashMap<>();
    }

    @Override
    public void add(@NotNull UUID uuid, @NotNull SetupData data) {
        dataMap.put(uuid, data);
    }

    @Override
    public @NotNull Optional<SetupData> remove(@NotNull UUID uuid) {
        return Optional.ofNullable(this.dataMap.remove(uuid));
    }

    @Override
    public @NotNull Optional<SetupData> get(@NotNull UUID uuid) {
        return Optional.ofNullable(this.dataMap.get(uuid));
    }

    @Override
    public @NotNull @UnmodifiableView Map<UUID, SetupData> getView() {
        return Collections.unmodifiableMap(this.dataMap);
    }
}
