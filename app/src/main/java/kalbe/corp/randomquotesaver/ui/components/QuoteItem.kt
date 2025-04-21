package kalbe.corp.randomquotesaver.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import kalbe.corp.randomquotesaver.R

@Composable
fun QuoteItem(
    quoteText: String,
    quoteAuthor: String,
    quoteCategory: String,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(colorResource(id = R.color.white))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "test",
            )
        }

        Row(

        ) {

        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun QuoteItemPreview(){
    QuoteItem(
        quoteText = "lorem ipsum",
        quoteAuthor = "lorem ipsum",
        quoteCategory = "History",
    )
}