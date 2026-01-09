import xyz.jpenilla.resourcefactory.bukkit.BukkitPluginYaml

plugins {
    `java-library`
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.19"
    id("xyz.jpenilla.run-paper") version "3.0.2"
    id("xyz.jpenilla.resource-factory-bukkit-convention") version "1.3.0"
    id("com.gradleup.shadow") version "9.3.0"
}

val pluginGroup: String by extra
val pluginVersion: String by extra
val pluginDescription: String by extra

val lampVersion: String by extra

val minecraftVersion: String by extra

val minimessageVersion: String by extra

group = pluginGroup
version = pluginVersion
description = pluginDescription

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

dependencies {
    paperweight.paperDevBundle("$minecraftVersion-R0.1-SNAPSHOT")
    implementation("io.github.revxrsal:lamp.common:$lampVersion")
    implementation("io.github.revxrsal:lamp.bukkit:$lampVersion")
    implementation("net.kyori:adventure-text-minimessage:$minimessageVersion")
}

tasks {
    compileJava {
        options.release = 21
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }
    runServer {
        minecraftVersion(minecraftVersion)
        downloadPlugins {}
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}


bukkitPluginYaml {
    main = "dev.d4nilpzz.pluginTemplate.PluginTemplate"
    load = BukkitPluginYaml.PluginLoadOrder.STARTUP
    authors.add("d4nilpzz")
    apiVersion = minecraftVersion
    version = pluginVersion
    description = pluginDescription
    name = "PluginTemplate"
}
