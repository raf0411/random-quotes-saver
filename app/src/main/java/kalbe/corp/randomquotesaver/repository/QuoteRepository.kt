package kalbe.corp.randomquotesaver.repository

import kalbe.corp.randomquotesaver.data.Quote
import kalbe.corp.randomquotesaver.data.QuoteDAO
import kotlinx.coroutines.flow.Flow

class QuoteRepository(private val quoteDAO: QuoteDAO) {
    suspend fun addQuote(quote: Quote){
        quoteDAO.addQuote(quote)
    }

    suspend fun editQuote(quote: Quote){
        quoteDAO.editQuote(quote)
    }

    suspend fun removeQuote(quote: Quote){
        quoteDAO.removeQuote(quote)
    }

    fun getAllQuotes(): Flow<List<Quote>>{
        return quoteDAO.getAllQuotes()
    }

    fun getQuoteById(id: Long): Flow<Quote>{
        return quoteDAO.getQuoteById(id)
    }
}