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
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
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
    navController: NavController,
) {
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }
    val navigationItems = listOf(
        NavigationItem(
            title = "Home Screen",
            icon = Icons.Outlined.Home,
            route = Routes.HomeScreen,
        ),
        NavigationItem(
            title = "Random Quotes Screen",
            icon = Icons.Outlined.Casino,
            route = Routes.RandomQuoteScreen,
        ),
        NavigationItem(
            title = "Settings Screen",
            icon = Icons.Outlined.Settings,
            route = Routes.SettingsScreen,
        ),
    )

    NavigationBar(
        containerColor = colorResource(id = R.color.blue_500)
    ) {
        navigationItems.forEachIndexed { index, item ->
            if (item.title == "Random Quotes Screen") {
                NavigationBarItem(
                    modifier = Modifier
                        .background(colorResource(
                            id = R.color.blue_400),
                            shape = CircleShape,
                        ),
                    selected = selectedNavigationIndex.intValue == index,
                    onClick = {
                        selectedNavigationIndex.intValue = index
                        navController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(48.dp),
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
                    selected = selectedNavigationIndex.intValue == index,
                    onClick = {
                        selectedNavigationIndex.intValue = index
                        navController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(48.dp),
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

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar(
        navController = rememberNavController()
    )
}