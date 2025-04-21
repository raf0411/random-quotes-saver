package kalbe.corp.randomquotesaver.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kalbe.corp.randomquotesaver.R
import kalbe.corp.randomquotesaver.ui.components.BottomBar
import kalbe.corp.randomquotesaver.ui.components.TopBar
import kalbe.corp.randomquotesaver.ui.screens.AddEditScreen
import kalbe.corp.randomquotesaver.ui.screens.HomeScreen
import kalbe.corp.randomquotesaver.ui.screens.RandomQuoteScreen
import kalbe.corp.randomquotesaver.ui.screens.SettingsScreen
import kalbe.corp.randomquotesaver.viewModels.QuoteViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val quoteViewModel: QuoteViewModel = viewModel()

    Scaffold(
        topBar = {
            TopBar(
                title = "Your Quotes",
            )
        },
        containerColor = colorResource(id = R.color.purple),
        bottomBar = { BottomBar(navController) }) { innerPadding ->
        NavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            startDestination = Routes.HomeScreen,
        ) {
            composable<Routes.HomeScreen> {
                HomeScreen()
            }

            composable<Routes.AddEditScreen> {
                AddEditScreen()
            }

            composable<Routes.RandomQuoteScreen> {
                RandomQuoteScreen()
            }

            composable<Routes.SettingsScreen> {
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