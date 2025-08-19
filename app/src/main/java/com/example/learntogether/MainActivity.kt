package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TextImageAffiche(
                        title = stringResource(R.string.title),
                        paragraph1 =  stringResource(R.string.paragraphe1),
                        paragraph2 =  stringResource(R.string.paragraphe2),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TextImageAffiche(title: String, paragraph1: String, paragraph2: String, modifier: Modifier = Modifier) {
    //recuperation de l'image
    val image = painterResource(R.drawable.bg_compose_background)

    Column {
        // affichage de l'image
        Image(
            painter = image,
            contentDescription = null,
        )

        // caracteristique du titre
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
                .padding(16.dp)
        )
        // caracteristique du paragraphe 1
        Text(
            text = paragraph1,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )

        )
        // caracteristique paragraphe 2
        Text(
            text = paragraph2,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

// fonction pour voir un apercu de l'interface
@Preview(showBackground = true)
@Composable
fun LearnTogetherPreview() {
    LearnTogetherTheme {
        TextImageAffiche(
            stringResource(R.string.title),
            stringResource(R.string.paragraphe1),
            stringResource(R.string.paragraphe2)
        )
    }
}