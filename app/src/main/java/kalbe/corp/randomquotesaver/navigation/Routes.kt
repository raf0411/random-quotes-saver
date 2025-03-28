package kalbe.corp.randomquotesaver.navigation

sealed class Routes{
    data object HomeScreen : Routes()

    data object AddEditScreen : Routes()

    data object RandomQuoteScreen : Routes()
}