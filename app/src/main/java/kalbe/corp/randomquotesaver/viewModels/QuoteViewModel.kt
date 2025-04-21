package kalbe.corp.randomquotesaver.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kalbe.corp.randomquotesaver.data.Graph
import kalbe.corp.randomquotesaver.data.Quote
import kalbe.corp.randomquotesaver.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class QuoteViewModel(
    private val quoteRepository: QuoteRepository = Graph.quoteRepository
) : ViewModel() {

    var quoteTextState by mutableStateOf("")
    var quoteAuthorState by mutableStateOf("")
    var quoteCategoryState by mutableStateOf("")

    lateinit var getAllQuotes: Flow<List<Quote>>

    init {
        viewModelScope.launch {
            getAllQuotes = quoteRepository.getAllQuotes()
        }
    }

    fun addQuote(quote: Quote) {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.addQuote(quote)
        }
    }

    fun editQuote(quote: Quote) {
        viewModelScope.launch {
            quoteRepository.editQuote(quote)
        }
    }

    fun removeQuote(quote: Quote) {
        viewModelScope.launch {
            quoteRepository.removeQuote(quote)
        }
    }

    fun getQuoteById(id: Long): Flow<Quote> {
        return quoteRepository.getQuoteById(id)
    }

    fun onQuoteTextChanged(newText: String) {
        quoteTextState = newText
    }

    fun onQuoteAuthorChanged(newAuthor: String) {
        quoteAuthorState = newAuthor
    }

    fun onQuoteCategoryChanged(newCategory: String) {
        quoteCategoryState = newCategory
    }
}