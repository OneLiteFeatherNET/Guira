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
            version("minestom", "1.5.1")
            version("aves", "1.6.1")
            version("junit", "5.12.1")
            version("publishdata", "1.4.0")
            version("jetbrains.annotation", "26.0.2")

            library("minestom", "net.onelitefeather.microtus", "Microtus").versionRef("minestom")
            library("minestom.test", "net.onelitefeather.microtus.testing", "testing").versionRef("minestom")

            library("aves", "de.icevizion.lib", "aves").versionRef("aves")

            library("junit.api", "org.junit.jupiter", "junit-jupiter-api").versionRef("junit")
            library("junit.engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
            library("jetbrains.annotation", "org.jetbrains", "annotations").versionRef("jetbrains.annotation")

            plugin("publishdata", "de.chojo.publishdata").versionRef("publishdata")
        }
    }
}

