package kalbe.corp.randomquotesaver.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class QuoteDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addQuote(quoteEntity: Quote)

    @Delete
    abstract suspend fun removeQuote(quoteEntity: Quote)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun editQuote(quoteEntity: Quote)

    @Query("SELECT * FROM `quote-table`")
    abstract fun getAllQuotes(): Flow<List<Quote>>

    @Query("SELECT * FROM `quote-table` WHERE id = :id")
    abstract fun getQuoteById(id: Long): Flow<Quote>
}