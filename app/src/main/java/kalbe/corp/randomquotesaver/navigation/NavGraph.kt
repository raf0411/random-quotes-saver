package kalbe.corp.randomquotesaver.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kalbe.corp.randomquotesaver.ui.screens.AddEditScreen
import kalbe.corp.randomquotesaver.ui.screens.HomeScreen
import kalbe.corp.randomquotesaver.ui.screens.RandomQuoteScreen
import kalbe.corp.randomquotesaver.ui.screens.SettingsScreen

@Composable
fun NavGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HomeScreen){
        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Routes.AddEditScreen> {
            AddEditScreen(navController)
        }

        composable<Routes.RandomQuoteScreen> {
            RandomQuoteScreen(navController)
        }

        composable<Routes.SettingsScreen> {
            SettingsScreen(navController)
        }
    }
}