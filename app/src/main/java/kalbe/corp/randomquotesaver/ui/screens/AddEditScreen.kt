package kalbe.corp.randomquotesaver.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kalbe.corp.randomquotesaver.R

@Composable
fun AddEditScreen(
    title: String,
    onConfirmClick: () -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var categories = listOf<String>("Category", "Education", "History", "Science", "Fiction")
    var categoryPosition by remember { mutableIntStateOf(0) }
    var textFieldSize by remember { mutableStateOf(IntSize.Zero) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
            label = { Text("Quote Text") },
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = colorResource(id = R.color.purple_100),
                focusedContainerColor = colorResource(id = R.color.purple_100),
            )
        )

        Spacer(Modifier.height(32.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
            label = { Text("Author") },
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = colorResource(id = R.color.purple_100),
                focusedContainerColor = colorResource(id = R.color.purple_100),
            )
        )

        Spacer(Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
            contentAlignment = Alignment.Center
        ) {
            OutlinedTextField(
                value = categories[categoryPosition],
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .onSizeChanged {
                        textFieldSize = it
                    }
                    .clickable { expanded = true },
                shape = RoundedCornerShape(16.dp),
                readOnly = true,
                trailingIcon = {
                    if (!expanded){
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "Select Category",
                            Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(colorResource(id = R.color.blue_100))
                                .clickable { expanded = true }
                        )
                    } else{
                        Icon(
                            imageVector = Icons.Filled.ArrowDropUp,
                            contentDescription = "Select Category",
                            Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(colorResource(id = R.color.blue_100))
                                .clickable { expanded = true }
                        )
                    }
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = colorResource(id = R.color.purple_100),
                    focusedContainerColor = colorResource(id = R.color.purple_100),

                    )
            )

            DropdownMenu(
                modifier = Modifier
                    .background(colorResource(id = R.color.purple_100))
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() }),
                expanded = expanded,
                onDismissRequest = { expanded = false },
                scrollState = rememberScrollState(),
                shape = RoundedCornerShape(12.dp)
            ) {
                categories.forEachIndexed { index, category ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = category,
                            )
                        },
                        onClick = {
                            expanded = false
                            categoryPosition = index
                        },
                    )
                }
            }
        }

        Spacer(Modifier.height(48.dp))

        Button(
            onClick = { onConfirmClick() },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.blue_300)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 6.dp, pressedElevation = 2.dp, disabledElevation = 0.dp
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(horizontal = 100.dp),
        ) {
            if (title == "Add Quote") {
                Text(
                    text = "Add",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            } else if (title == "Edit Quote") {
                Text(
                    text = "Edit",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}