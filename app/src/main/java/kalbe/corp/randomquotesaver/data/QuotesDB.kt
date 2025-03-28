package kalbe.corp.randomquotesaver.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Quote::class],
    version = 1,
    exportSchema = false,
)

abstract class QuotesDB: RoomDatabase(){
    abstract fun quoteDAO(): QuoteDAO
}