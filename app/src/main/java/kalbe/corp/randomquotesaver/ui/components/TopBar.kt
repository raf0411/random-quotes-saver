package kalbe.corp.randomquotesaver.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kalbe.corp.randomquotesaver.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String = "Your Quotes",
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val backNavigationIcon: (@Composable () -> Unit)? =
        if (title.contains("Add/Edit Quote")) {
        {
            Row {
                Spacer(Modifier.width(16.dp))
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(
                            colorResource(id = R.color.nav_btn_color), shape = CircleShape
                        )
                        .size(32.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        tint = colorResource(id = R.color.transparent_white),
                        contentDescription = null,
                    )
                }
            }
        }
    } else {
        null
    }

    val filterIcon: (@Composable () -> Unit)? =
        if (title.contains("Your Quotes")) {
            {
                Row {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .background(
                                colorResource(id = R.color.nav_btn_color), shape = RoundedCornerShape(12.dp)
                            )
                            .size(32.dp)
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Outlined.FilterAlt,
                            tint = colorResource(id = R.color.white),
                            contentDescription = null,
                        )
                    }
                    Spacer(Modifier.width(16.dp))
                }
            }
        } else {
            null
        }

    CenterAlignedTopAppBar(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        title = {
            Text(
                text = title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colorResource(id = R.color.blue_500)
        ),
        navigationIcon = { backNavigationIcon?.invoke() },
        actions = { filterIcon?.invoke() },
        scrollBehavior = scrollBehavior,
    )
}

@Composable
@Preview
fun TopBarPreview() {
    TopBar()
}