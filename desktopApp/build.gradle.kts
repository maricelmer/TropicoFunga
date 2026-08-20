import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

dependencies {
    implementation(project(":shared"))

    implementation(compose.desktop.currentOs)
    implementation(libs.kotlinx.coroutinesSwing)

    implementation(libs.compose.components.resources)
    implementation(libs.compose.uiToolingPreview)

    implementation(libs.koin.core)
    implementation(libs.multiplatform.settings)
}

// Origem unica de versao: mesma app.version usada pelo androidApp (gradle.properties).
val appVersion = (project.findProperty("app.version") as String?)
    ?: error("Defina app.version em gradle.properties, ex: app.version=26.1.0")

compose.desktop {
    application {
        mainClass = "br.com.monolit.tropicofunga.main.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            // Nome de exibicao (titulo do instalador, pasta em Program Files, atalho, dock
            // no macOS) - equivalente ao android:label="Tropico Funga" do Android.
            packageName = "Tropico Funga"
            packageVersion = appVersion
            description = "Tropico Funga"
            // Sem isso o jpackage usa "Unknown" como fabricante/publisher (visivel no
            // instalador e em Programas e Recursos). Inferido do applicationId
            // br.com.monolit.tropicofunga - ajuste se o nome da empresa for outro.
            vendor = "Monolit Tecnologia"

            windows {
                iconFile.set(project.file("src/main/resources/icons/icon.ico"))
                menuGroup = "Tropico Funga"
                shortcut = true
                menu = true
                // UUID fixo - NUNCA trocar. O instalador MSI usa isso para saber que uma
                // nova versao e um upgrade da anterior (e nao uma instalacao paralela).
                // Mesmo principio do keystore de assinatura do Android: gerado uma vez,
                // versionado, nunca regenerado.
                upgradeUuid = "A96303BB-8351-4A90-9AB9-2F7E11026FA7"
            }
            macOS {
                iconFile.set(project.file("src/main/resources/icons/icon.icns"))
                bundleID = "br.com.monolit.tropicofunga"
            }
            linux {
                iconFile.set(project.file("src/main/resources/icons/icon.png"))
                // Debian exige nome de pacote em minusculas, sem espaco/acento.
                packageName = "tropico-funga"
            }
        }
    }
}