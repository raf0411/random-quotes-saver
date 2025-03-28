package kalbe.corp.randomquotesaver.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kalbe.corp.randomquotesaver.ui.screens.AddEditScreen
import kalbe.corp.randomquotesaver.ui.screens.HomeScreen
import kalbe.corp.randomquotesaver.ui.screens.RandomQuoteScreen

@Composable
fun NavGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HomeScreen){
        composable<Routes.HomeScreen> {
            HomeScreen()
        }

        composable<Routes.AddEditScreen> {
            AddEditScreen()
        }

        composable<Routes.RandomQuoteScreen> {
            RandomQuoteScreen()
        }
    }
}