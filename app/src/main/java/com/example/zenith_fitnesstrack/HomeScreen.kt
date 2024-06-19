package com.example.zenith_fitnesstrack

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.zenith_fitnesstrack.pages.Homepage
import com.example.zenith_fitnesstrack.pages.Profilepage
import com.example.zenith_fitnesstrack.pages.Progresspage


@Preview(showSystemUi = true, showBackground = true,
    device = "spec:id=reference_phone,shape=Normal,width=411,height=891,unit=dp,dpi=420"
)
@Composable
fun Home() {

    val navItems = listOf(
        // maximum items are 5
        Navitem("Home", Icons.Default.Home),
        Navitem("Home", Icons.Default.CheckCircle),
        Navitem("Home", Icons.Default.Person),
    )
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                //NavigationBarItem(selected = , onClick = { /*TODO*/ }, icon = { /*TODO*/ })
                navItems.forEachIndexed {
                        index, item ->
                    NavigationBarItem(
                        selected = selectedIndex == index ,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
//                            BadgedBox(badge = {
//                            if(navItem.badgeCount>0)
//                                Badge(){
//                                    Text(text = 5.toString())
//                                }
//
//                            }) {
//                                Icon(imageVector = item.icon, contentDescription = "Icon")
//                            }
                            Icon(imageVector = item.icon, contentDescription = "Icon")
                        },
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex)

    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
    when(selectedIndex){
        0 -> Homepage(modifier)
        1 -> Progresspage(modifier)
        2 -> Profilepage(modifier)
    }

}