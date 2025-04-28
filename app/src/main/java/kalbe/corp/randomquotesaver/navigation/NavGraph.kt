package kalbe.corp.randomquotesaver.navigation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
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
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopBar(
                title = topBarTitle,
                onFilterClick = {
                    // TODO Filter Action
                    Toast.makeText(context, "Filter Clicked!", Toast.LENGTH_SHORT).show()
                },
            )
        },
        containerColor = colorResource(id = R.color.purple),
        bottomBar = {
            BottomBar(
                currentRoute = currentRoute,
                onNavigate = { route, title ->
                    Log.d("RouteCheck", route)
                    topBarTitle = title
                    navController.navigate(route) {
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
                    navController = navController,
                    quoteViewModel = quoteViewModel,
                    onAddQuoteButtonClick = {
                        topBarTitle = "Add Quote"
                        navController.navigate(Routes.AddEditScreen.route)
                    },
                    onEditQuoteButtonClick = {
                        topBarTitle = "Edit Quote"
                        navController.navigate(Routes.AddEditScreen.route)
                    }
                )
            }

            composable(Routes.AddEditScreen.route) {
                AddEditScreen(
                    title = topBarTitle,
                    onConfirmClick = {
                        topBarTitle = "Your Quotes"
                        navController.navigate(Routes.HomeScreen.route)
                    })
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