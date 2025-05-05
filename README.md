# Guira

Guira is a lightweight Java library designed to help you implement flexible and robust setup processes for games, minigames, or any other custom features on a [Minestom](https://github.com/Minestom/Minestom) server. Rather than enforcing a fixed setup structure, Guira empowers you to define exactly what your setup should contain—such as maps, teams, rules, or any other configuration—by letting you design your own setup data types and logic. The library provides a solid and extensible foundation for storing, tracking, and managing this setup data, making it easy to build tailored setup flows for a wide range of server scenarios.

## Installation

Add the following to your `build.gradle.kts`:

```kotlin
dependencies {
    compileOnly("net.onelitefeather.guira:guira:<version>>")
}
```

## Usage Example

```java
// Create a new SetupDataService instance
SetupDataService<MySetupData> service = SetupDataService.create();

// Add setup data
UUID uuid = UUID.randomUUID();
MySetupData data = new MySetupData(uuid, ...);
service.add(uuid, data);

// Retrieve setup data
Optional<MySetupData> retrieved = service.get(uuid);

// Remove setup data
service.remove(uuid);
```

### Event Handling

Guira provides events such as `SetupCreateEvent` and `SetupFinishEvent` for managing the setup process lifecycle.

> [!NOTE]
> **Guira does NOT automatically fire any of the provided events (`SetupCreateEvent`, `SetupFinishEvent`, etc).**
> You are responsible for triggering and handling these events in your own code/context (e.g., your Minestom server plugin or application).

## License

This project is licensed under the [Apache License 2.0](LICENSE).