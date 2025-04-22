package kalbe.corp.randomquotesaver.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Card
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kalbe.corp.randomquotesaver.R
import kalbe.corp.randomquotesaver.data.Quote

@Composable
fun QuoteItem(
    quote: Quote,
    onQuoteClick: () -> Unit,
    onRemoveClick: () -> Unit,
    onEditClick: () -> Unit,
) {
    fun limitStringOneLine(input: String, maxLength: Int = 28): String =
        if (input.length <= maxLength) input else input.take(maxLength - 3) + "..."

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onQuoteClick()
            },
        shape = RoundedCornerShape(24.dp),
        elevation = 12.dp,
        backgroundColor = colorResource(id = R.color.white)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = "”${limitStringOneLine(quote.text)}”",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic,
                )

                Spacer(Modifier.height(14.dp))

                Text(
                    text = quote.author,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                )
            }

            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = quote.category,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                )

                Spacer(Modifier.height(14.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(
                        onClick = { onEditClick() },
                        modifier = Modifier
                            .background(
                                colorResource(id = R.color.nav_btn_color),
                                shape = RoundedCornerShape(4.dp),
                            )
                            .size(24.dp)
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp),
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = "Edit",
                            tint = colorResource(id = R.color.teal_700),
                        )
                    }

                    Spacer(Modifier.width(12.dp))

                    IconButton(
                        onClick = { onRemoveClick() },
                        modifier = Modifier
                            .background(
                                colorResource(id = R.color.nav_btn_color),
                                shape = RoundedCornerShape(4.dp),
                            )
                            .size(24.dp)
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp),
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = "Edit",
                            tint = Color.Red,
                        )
                    }
                }
            }
        }

    }
}