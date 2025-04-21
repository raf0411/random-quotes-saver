package kalbe.corp.randomquotesaver.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kalbe.corp.randomquotesaver.R
import kalbe.corp.randomquotesaver.viewModel.QuoteViewModel

@Composable
fun HomeScreen(
    quoteViewModel: QuoteViewModel,
) {
    val quotes = quoteViewModel.getAllQuotes.collectAsState(initial = listOf())

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