pluginManagement {
    repositories {
        // Repos para plugins (AGP, Kotlin, etc.)
        google {
            content {
                // AGP y plugins de Google/AndroidX
                includeGroupByRegex("com\\.android(\\..*)?")
                includeGroupByRegex("com\\.google(\\..*)?")
                includeGroupByRegex("androidx(\\..*)?")
            }
        }
        // Kotlin Gradle Plugin y otros plugins comunitarios
        gradlePluginPortal()
        // Plugins publicados en Maven Central (algunos terceros)
        mavenCentral()
    }
}

dependencyResolutionManagement {
    // Evita repos en módulos y fuerza estos de raíz
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // Dependencias de AndroidX / Google
        google()
        // Resto de dependencias (Navigation, Lifecycle, Window, Coil, etc.)
        mavenCentral()
    }
}

rootProject.name = "MyAPP"
include(":app")