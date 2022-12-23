package br.pro.celsofurtado.gamejc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.pro.celsofurtado.gamejc.dao.categoriesListSample
import br.pro.celsofurtado.gamejc.dao.sampleMeditationList
import br.pro.celsofurtado.gamejc.ui.theme.GameJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameJCTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(254, 249, 231)) {
                    Column {
                        Profile()
                        SearchBar()
                        CategoriesList()
                        MeditationList()
                    }
                }
            }
        }
    }
}

@Composable
fun Profile() {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.andrea_profile),
                contentDescription = "Photo profile",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.welcome)
                )
                Text(
                    text = "Miranda Smith",
                    fontSize = 22.sp
                )
            }
        }
        Icon(
            modifier = Modifier.padding(end = 8.dp),
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notification icon",
        )
    }
}

@Composable
fun SearchBar() {
    var searchText by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        //.border(width = 2.dp, color = Color.Green, shape = RoundedCornerShape(16.dp))
        //.background(Color.Yellow),
        value = searchText,
        onValueChange = {
            searchText = it
        },
        shape = RoundedCornerShape(8.dp),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon")
        },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings icon")
        }
    )
}

@Composable
fun CategoriesList() {
    LazyRow(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        items(categoriesListSample()) { category ->
            Card(
                modifier = Modifier
                    .padding(4.dp),
                backgroundColor = category.color,
                elevation = 0.dp
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    text = category.categoryName,
                    color = category.textColor
                )
            }
        }
    }
}

@Composable
fun MeditationList() {
    LazyColumn(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)){
        items(sampleMeditationList()) { meditation ->
            Card(
                modifier = Modifier
                    .padding(4.dp),
                backgroundColor = meditation.meditationColor,
                elevation = 0.dp,
                shape = RoundedCornerShape(16.dp)
            ) {

                Column(modifier = Modifier.padding(16.dp)) {
                    Row {
                        Text(
                            modifier = Modifier.padding(end = 24.dp).background(Color.Gray),
                            text = " ${meditation.meditationTime} mins ",
                        )
                        Text(
                            modifier = Modifier.padding(end = 24.dp).background(Color.Cyan),
                            text = "${meditation.meditationAuthor}"
                        )
                    }
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = "${meditation.meditationTitle}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                    Text(text = "${meditation.meditationText}")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    GameJCTheme {
        Profile()
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    GameJCTheme {
        SearchBar()
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesListPreview() {
    GameJCTheme {
        CategoriesList()
    }
}

@Preview(showBackground = true)
@Composable
fun MeditationListPreview() {
    GameJCTheme {
        MeditationList()
    }
}