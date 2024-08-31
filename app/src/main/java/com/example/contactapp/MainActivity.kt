package com.example.contactapp

//import com.example.contactapp.Contact
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contactapp.ui.theme.ContactAppTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            ContactAppTheme {
                Scaffold( modifier = Modifier.fillMaxWidth(),
                    topBar = {
                    TopAppBar(
                        title = {Text(text = stringResource(id = R.string.app_name))},
                        actions = {
                            IconButton(onClick = {
                                val phone = "+20105287564"
                                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                                context.startActivity(intent)
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_home_24),
                                    contentDescription =null )
                            }
                        })}
                ) {innerPadding ->
                    lazyrow(
                        contact = DataSource().getContact(),
                        modifier = Modifier.padding(innerPadding))

                }
            }
            }
        }
    }

    @Composable
    fun lazyrow(contact: List<Contact>, modifier: Modifier = Modifier) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(count = 3),

        ) {
            items(contact) {
                ContactScreen(contact = it)
            }
        }
    }

    @Composable
    fun ContactScreen(contact: Contact, modifier: Modifier = Modifier) {

        val context = LocalContext.current
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            ImageWithText(
                painter = painterResource(id = contact.image),
                text1 = stringResource(id = contact.name),
                text2 = stringResource(id = contact.phone),

                )

        }

    }

    @Composable
    fun TopBar(modifier: Modifier = Modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.app_name))
            Icon(
                painter = painterResource(id = R.drawable.baseline_home_24),
                contentDescription = null
            )
        }

    }


    @Composable
    fun ImageWithText(painter: Painter, text1: String, text2: String) {

        val context = LocalContext.current

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Color.Gray)
                .clickable {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$text2"))
                    context.startActivity(intent)
                }

        )
        {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(137.dp)
            )
            // Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = text1,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis
            )
            SelectionContainer {
                Text(
                    text = text2,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
            }


        }
    }

fun test(s:Int){
    s+3
}

//unable to access 'https://github.com/yousefezz156/ContactApp.git/'
//hello test

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    private fun ContactView() {
        lazyrow(contact = DataSource().getContact())
    }
