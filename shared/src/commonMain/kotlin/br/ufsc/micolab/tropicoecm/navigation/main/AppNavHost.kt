package br.ufsc.micolab.tropicoecm.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.ufsc.micolab.tropicoecm.features.about.screen.AboutScreen
import br.ufsc.micolab.tropicoecm.features.ectomycorrhizae.screen.EctomycorrhizaeScreen
import br.ufsc.micolab.tropicoecm.features.fungi.screen.FungiScreen
import br.ufsc.micolab.tropicoecm.features.glossary.screen.GlossaryScreen
import br.ufsc.micolab.tropicoecm.features.home.screen.HomeScreen
import br.ufsc.micolab.tropicoecm.features.hosts.screen.HostsScreen
import br.ufsc.micolab.tropicoecm.features.howToCollect.screen.HowToCollectScreen
import br.ufsc.micolab.tropicoecm.navigation.routes.AppRoutes

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