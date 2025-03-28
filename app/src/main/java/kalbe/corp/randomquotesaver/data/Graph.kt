package kalbe.corp.randomquotesaver.data

import android.content.Context
import androidx.room.Room
import kalbe.corp.randomquotesaver.repository.QuoteRepository

object Graph {
    lateinit var db: QuotesDB

    val quoteRepository by lazy {
        QuoteRepository(quoteDAO = db.quoteDAO())
    }

    fun provide(context: Context) {
        db = Room.databaseBuilder(context, QuotesDB::class.java, "quotes.db").build()
    }
}