package kalbe.corp.randomquotesaver.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes{
    @Serializable
    data object HomeScreen : Routes()

    @Serializable
    data object AddEditScreen : Routes()

    @Serializable
    data object RandomQuoteScreen : Routes()

    @Serializable
    data object SettingsScreen : Routes()
}