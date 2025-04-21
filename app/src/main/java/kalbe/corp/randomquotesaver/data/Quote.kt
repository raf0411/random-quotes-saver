package kalbe.corp.randomquotesaver.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Entity(tableName = "quote-table")
data class Quote(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "quote-text") var text: String = "",
    @ColumnInfo(name = "quote-author") var author: String = "",
    @ColumnInfo(name = "quote-category") var category: String = "Uncategorized",
    @ColumnInfo(name = "quote-timestamp") val timestamp: String = SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss", Locale.getDefault()
    ).format(Date())
)