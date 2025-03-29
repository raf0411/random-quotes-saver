package kalbe.corp.randomquotesaver.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kalbe.corp.randomquotesaver.ui.components.BottomBar
import kalbe.corp.randomquotesaver.ui.components.TopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen(
    navController: NavController
){
    Scaffold(
        topBar = { TopBar(
            title = "Settings"
        ) },
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        Text("Home Screen")
    }
}