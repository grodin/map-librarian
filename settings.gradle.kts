import de.fayard.refreshVersions.bootstrapRefreshVersions

pluginManagement {
    resolutionStrategy {
        val pluginIdToCoordinates = mapOf(
            "com.google.gms.google-services" to "com.google.gms:google-services"
        )
        eachPlugin {
            pluginIdToCoordinates[requested.id.id]?.also { useModule("$it:${requested.version}") }
        }
    }
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        jcenter()
        mavenLocal()
    }
}
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("de.fayard.refreshVersions:refreshVersions:0.9.7")
    }
}

bootstrapRefreshVersions()

rootProject.name = ("map-librarian")

include(
    "app"
)
