package kalbe.corp.randomquotesaver.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kalbe.corp.randomquotesaver.R
import kalbe.corp.randomquotesaver.data.Quote
import kalbe.corp.randomquotesaver.ui.components.QuoteItem
import kalbe.corp.randomquotesaver.viewModel.QuoteViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(
    quoteViewModel: QuoteViewModel,
) {
    val quotes = quoteViewModel.getAllQuotes.collectAsState(initial = listOf())
    fun getDummyQuotes(): List<Quote> {
        fun getCurrentTimestamp(): String {
            return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        }

        return listOf(
            Quote(
                text = "The only way to do great work is to love what you do.",
                author = "Steve Jobs",
                category = "Motivation",
                timestamp = getCurrentTimestamp()
            ),
            Quote(
                text = "Strive not to be a success, but rather to be of value.",
                author = "Albert Einstein",
                category = "Wisdom",
                timestamp = getCurrentTimestamp()
            ),
            Quote(
                text = "The mind is everything. What you think you become.",
                author = "Buddha",
                category = "Philosophy",
                timestamp = getCurrentTimestamp()
            ),
            Quote(
                text = "An unexamined life is not worth living.",
                author = "Socrates",
                category = "Philosophy",
            ),
            Quote(
                text = "Your time is limited, don't waste it living someone else's life.",
                author = "Steve Jobs",
                category = "Motivation",
                timestamp = getCurrentTimestamp()
            )
        )
    }
    val quoteList = getDummyQuotes()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .width(128.dp)
                .height(64.dp)
                .background(colorResource(R.color.blue_300), RoundedCornerShape(24.dp))
        ) {
            Icon(
                modifier = Modifier.size(48.dp),
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                tint = colorResource(id = R.color.white)
            )
        }

        Spacer(Modifier.height(64.dp))

        if(!quoteList.isEmpty()){
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                items(quoteList) { quote ->
                    QuoteItem(
                        quote = quote,
                        onQuoteClick = {
                            // TODO Quote Detail Action
                        },
                        onRemoveClick = {
                            // TODO Quote Remove Action
                        },
                        onEditClick = {
                            // TODO Quote Edit Action
                        },
                    )
                }
            }
        } else{
            Text(
                text = "“No Live Saving Quotes around...”",
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                color = colorResource(R.color.transparent_black)
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        quoteViewModel = QuoteViewModel()
    )
}