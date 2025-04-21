package kalbe.corp.randomquotesaver.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kalbe.corp.randomquotesaver.R
import kalbe.corp.randomquotesaver.ui.components.BottomBar
import kalbe.corp.randomquotesaver.ui.components.TopBar
import kalbe.corp.randomquotesaver.ui.screens.AddEditScreen
import kalbe.corp.randomquotesaver.ui.screens.HomeScreen
import kalbe.corp.randomquotesaver.ui.screens.RandomQuoteScreen
import kalbe.corp.randomquotesaver.ui.screens.SettingsScreen
import kalbe.corp.randomquotesaver.viewModel.QuoteViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val quoteViewModel: QuoteViewModel = viewModel()
    var topBarTitle by remember { mutableStateOf("Your Quotes") }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopBar(
                title = topBarTitle,
                onFilterClick = {
                    // TODO Filter Action
                },
            )
        },
        containerColor = colorResource(id = R.color.purple),
        bottomBar = {
            BottomBar(
                currentRoute = currentRoute,
                onNavigate = { route, title ->
                    topBarTitle = title
                    navController.navigate(route){
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        },
    ) { innerPadding ->

        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Routes.HomeScreen.route,
        ) {
            composable(Routes.HomeScreen.route) {
                HomeScreen(
                    quoteViewModel = quoteViewModel,
                )
            }

            composable(Routes.AddEditScreen.route) {
                AddEditScreen()
            }

            composable(Routes.RandomQuoteScreen.route) {
                RandomQuoteScreen()
            }

            composable(Routes.SettingsScreen.route) {
                SettingsScreen()
            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun NavGraphPreview(){
    NavGraph()
}