package kalbe.corp.randomquotesaver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.sp
import kalbe.corp.randomquotesaver.ui.theme.RandomQuoteSaverTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import kalbe.corp.randomquotesaver.navigation.NavGraph

val poppinsFont = FontFamily(
    Font (
        googleFont = GoogleFont("Poppins"),
        fontProvider = GoogleFont.Provider(
            providerAuthority = "com.google.android.gms.fonts",
            providerPackage = "com.google.android.gms",
            certificates = emptyList()
        ),
        weight = FontWeight.Normal
    )
)

val CustomTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = poppinsFont,
        fontSize = 18.sp
    ),
    titleLarge = TextStyle(
        fontFamily = poppinsFont,
        fontSize = 24.sp
    ),
    labelSmall = TextStyle(
        fontFamily = poppinsFont,
        fontSize = 12.sp
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomQuoteSaverTheme {
                MaterialTheme(
                    typography = CustomTypography,
                ){
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    NavGraph()
}