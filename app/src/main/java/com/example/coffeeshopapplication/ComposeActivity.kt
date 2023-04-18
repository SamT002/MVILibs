package com.example.coffeeshopapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.coffeeshopapplication.ui.theme.CoffeeShopApplicationTheme

class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CoffeeShopApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    UserMessage("First", "Second")
                }
            }
        }
    }

    @OptIn(ExperimentalUnitApi::class)
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "DarkMode"
    )
    @Preview(
        name = "LightMode"
    )
    @Composable
    fun UserMessage(firstMessage: String = "First", secondMessage: String = "Second") {
        CoffeeShopApplicationTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                Row(Modifier.padding(10.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.test_image),
                        contentDescription = String(),
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)

                    )
                    Spacer(Modifier.width(20.dp))
                    Column {
                        Text(
                            text = firstMessage,
                            fontSize = TextUnit(16f, TextUnitType.Sp),
                            color = MaterialTheme.colors.secondaryVariant,
                            style = MaterialTheme.typography.subtitle2

                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        Surface(
                            shape = MaterialTheme.shapes.medium.copy(CornerSize(12.dp)),
                            elevation = 10.dp
                        ) {
                            Text(
                                text = secondMessage,
                                fontSize = TextUnit(16f, TextUnitType.Sp),
                                style = MaterialTheme.typography.subtitle2,
                                modifier = Modifier.padding(12.dp)
                            )
                        }
                    }
                }
            }
        }
    }

}