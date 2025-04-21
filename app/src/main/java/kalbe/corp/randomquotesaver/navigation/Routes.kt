package kalbe.corp.randomquotesaver.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(
    val route: String,
){
    @Serializable
    data object HomeScreen : Routes("home_screen")

    @Serializable
    data object AddEditScreen : Routes("add_edit_screen")

    @Serializable
    data object RandomQuoteScreen : Routes("random_quote_screen")

    @Serializable
    data object SettingsScreen : Routes("settings_screen")
}