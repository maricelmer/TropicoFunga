package br.com.monolit.tropicofunga.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.monolit.tropicofunga.features.about.screen.AboutScreen
import br.com.monolit.tropicofunga.features.ectomycorrhizae.screen.EctomycorrhizaeScreen
import br.com.monolit.tropicofunga.features.fungi.screen.FungiScreen
import br.com.monolit.tropicofunga.features.glossary.screen.GlossaryScreen
import br.com.monolit.tropicofunga.features.home.screen.HomeScreen
import br.com.monolit.tropicofunga.features.hosts.screen.HostsScreen
import br.com.monolit.tropicofunga.features.howToCollect.screen.HowToCollectScreen
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
        composable<AppRoutes.Home> {
            HomeScreen(
                openEctomycorrhizae = {
                    navHostController.navigate(AppRoutes.Ectomycorrhizae)
                },
                openHowToCollect = {
                    navHostController.navigate(AppRoutes.HowToCollect)
                },
                openGlossary = {
                    navHostController.navigate(AppRoutes.Glossary)
                },
                openFungi = {
                    navHostController.navigate(AppRoutes.Fungi)
                },
                openHosts = {
                    navHostController.navigate(AppRoutes.Hosts)
                },
                openAbout = {
                    navHostController.navigate(AppRoutes.About)
                },
            )
        }
        composable<AppRoutes.Ectomycorrhizae> {
            EctomycorrhizaeScreen(onBackPressed = navHostController::popBackStack)
        }
        composable<AppRoutes.HowToCollect> {
            HowToCollectScreen(onBackPressed = navHostController::popBackStack)
        }
        composable<AppRoutes.Glossary> {
            GlossaryScreen(onBackPressed = navHostController::popBackStack)
        }
        composable<AppRoutes.Fungi> {
            FungiScreen(onBackPressed = navHostController::popBackStack)
        }
        composable<AppRoutes.Hosts> {
            HostsScreen(onBackPressed = navHostController::popBackStack)
        }
        composable<AppRoutes.About> {
            AboutScreen(onBackPressed = navHostController::popBackStack)
        }
    }
}