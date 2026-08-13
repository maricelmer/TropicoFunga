package br.com.monolit.tropicofunga.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.about.screen.AboutScreen
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.screen.EctomycorrhizaeScreen
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.screen.FungiScreen
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.screen.GlossaryScreen
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.home.screen.AtlasMycorrhizaeHomeScreen
import br.com.monolit.tropicofunga.features.home.screen.HomeScreen
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.screen.HostsScreen
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.howToCollect.screen.HowToCollectScreen
import br.com.monolit.tropicofunga.features.funga.home.screen.FungaHomeScreen
import br.com.monolit.tropicofunga.navigation.routes.AppRoutes

@Composable
fun AppNavHost(
    modifier: Modifier,
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = AppRoutes.Home,
        modifier = modifier,
    ) {
        // Home
        composable<AppRoutes.Home> {
            HomeScreen(
                openFunga = {
                    navHostController.navigate(AppRoutes.Funga.Home)
                },
                openAtlasMycorrhizae = {
                    navHostController.navigate(AppRoutes.AtlasMycorrhizae.Home)
                },
            )
        }

        // Funga
        composable<AppRoutes.Funga.Home> {
            FungaHomeScreen(onBackPressed = navHostController::popBackStack)
        }

        // Atlas Mycorrhizae
        composable<AppRoutes.AtlasMycorrhizae.Home> {
            AtlasMycorrhizaeHomeScreen(
                openEctomycorrhizae = {
                    navHostController.navigate(AppRoutes.AtlasMycorrhizae.Ectomycorrhizae)
                },
                openHowToCollect = {
                    navHostController.navigate(AppRoutes.AtlasMycorrhizae.HowToCollect)
                },
                openGlossary = {
                    navHostController.navigate(AppRoutes.AtlasMycorrhizae.Glossary)
                },
                openFungi = {
                    navHostController.navigate(AppRoutes.AtlasMycorrhizae.Fungi)
                },
                openHosts = {
                    navHostController.navigate(AppRoutes.AtlasMycorrhizae.Hosts)
                },
                openAbout = {
                    navHostController.navigate(AppRoutes.AtlasMycorrhizae.About)
                },
                onBackPressed = navHostController::popBackStack
            )
        }
        composable<AppRoutes.AtlasMycorrhizae.Ectomycorrhizae> {
            EctomycorrhizaeScreen(onBackPressed = navHostController::popBackStack)
        }
        composable<AppRoutes.AtlasMycorrhizae.HowToCollect> {
            HowToCollectScreen(onBackPressed = navHostController::popBackStack)
        }
        composable<AppRoutes.AtlasMycorrhizae.Glossary> {
            GlossaryScreen(onBackPressed = navHostController::popBackStack)
        }
        composable<AppRoutes.AtlasMycorrhizae.Fungi> {
            FungiScreen(onBackPressed = navHostController::popBackStack)
        }
        composable<AppRoutes.AtlasMycorrhizae.Hosts> {
            HostsScreen(onBackPressed = navHostController::popBackStack)
        }
        composable<AppRoutes.AtlasMycorrhizae.About> {
            AboutScreen(onBackPressed = navHostController::popBackStack)
        }
    }
}