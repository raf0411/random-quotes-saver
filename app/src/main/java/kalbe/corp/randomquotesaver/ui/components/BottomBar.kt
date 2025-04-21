package kalbe.corp.randomquotesaver.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Casino
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kalbe.corp.randomquotesaver.R
import kalbe.corp.randomquotesaver.navigation.NavigationItem
import kalbe.corp.randomquotesaver.navigation.Routes

@Composable
fun BottomBar(
    onNavigate: (route: String, title: String) -> Unit,
    currentRoute: String?
) {
    val navigationItems = listOf(
        NavigationItem(
            title = "Your Quotes",
            icon = Icons.Outlined.Home,
            route = Routes.HomeScreen.route,
        ),
        NavigationItem(
            title = "Random Quotes",
            icon = Icons.Outlined.Casino,
            route = Routes.RandomQuoteScreen.route,
        ),
        NavigationItem(
            title = "Settings",
            icon = Icons.Outlined.Settings,
            route = Routes.SettingsScreen.route,
        ),
    )

    val selectedIndex = navigationItems.indexOfFirst { it.route == currentRoute }.coerceAtLeast(0)
    NavigationBar(
        containerColor = colorResource(id = R.color.blue_500)
    ) {
        navigationItems.forEachIndexed { index, item ->
            val isSelected = index == selectedIndex

            if (item.title == "Random Quotes") {
                NavigationBarItem(
                    selected = isSelected,
                    onClick = { onNavigate(item.route, item.title) },
                    icon = {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = colorResource(id = R.color.white),
                        unselectedIconColor = colorResource(id = R.color.transparent_white),
                        indicatorColor = Color.Transparent,
                    ),
                )
            } else {
                NavigationBarItem(
                    selected = isSelected,
                    onClick = { onNavigate(item.route, item.title) },
                    icon = {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = colorResource(id = R.color.white),
                        unselectedIconColor = colorResource(id = R.color.transparent_white),
                        indicatorColor = Color.Transparent,
                    ),
                )
            }
        }
    }
}