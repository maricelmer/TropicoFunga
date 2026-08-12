package br.ufsc.micolab.tropicoecm.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.ufsc.micolab.tropicoecm.features.home.screen.HomeScreen
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

        }
        composable<AppRoutes.HowToCollect> {

        }
        composable<AppRoutes.Glossary> {

        }
        composable<AppRoutes.Fungi> {

        }
        composable<AppRoutes.Hosts> {

        }
        composable<AppRoutes.About> {

        }
    }
}