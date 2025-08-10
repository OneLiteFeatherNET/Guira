rootProject.name = "guira"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://eldonexus.de/repository/maven-public/")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven {
            name = "OneLiteFeatherRepository"
            url = uri("https://repo.onelitefeather.dev/onelitefeather")
            if (System.getenv("CI") != null) {
                credentials {
                    username = System.getenv("ONELITEFEATHER_MAVEN_USERNAME")
                    password = System.getenv("ONELITEFEATHER_MAVEN_PASSWORD")
                }
            } else {
                credentials(PasswordCredentials::class)
                authentication {
                    create<BasicAuthentication>("basic")
                }
            }
        }
    }
    versionCatalogs {
        create("libs") {
            version("aves", "1.10.0")
            version("publishdata", "1.4.0")
            version("bom", "1.4.3")

            library("mycelium.bom", "net.onelitefeather", "mycelium-bom").versionRef("bom")

            library("minestom","net.minestom", "minestom").withoutVersion()
            library("cyano", "net.onelitefeather", "cyano").withoutVersion()

            library("aves", "net.theevilreaper", "aves").versionRef("aves")

            library("junit.api", "org.junit.jupiter", "junit-jupiter-api").withoutVersion()
            library("junit.engine", "org.junit.jupiter", "junit-jupiter-engine").withoutVersion()
            library("junit.platform.launcher", "org.junit.platform", "junit-platform-launcher").withoutVersion()
            library("jetbrains.annotation", "org.jetbrains", "annotations").withoutVersion()

            plugin("publishdata", "de.chojo.publishdata").versionRef("publishdata")
        }
    }
}

