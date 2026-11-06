package com.loveconnect.app.ui.screens

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.loveconnect.app.ui.theme.CardDark
import com.loveconnect.app.ui.theme.RedPrimary
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Settings

@Composable
fun LoveConnectBottomBar(
    selectedTab: Int,
    tabs: List<String>,
    onTabSelected: (Int) -> Unit,
) {
    BottomAppBar(
        containerColor = CardDark,
        contentColor = Color.White,
        tonalElevation = 8.dp,
    ) {
        val icons = listOf(Icons.Default.Link, Icons.Default.ChatBubble, Icons.Default.Settings)

        tabs.forEachIndexed { index, label ->
            NavigationBarItem(
                selected = selectedTab == index,
                onClick = { onTabSelected(index) },
                icon = {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = label,
                        tint = if (selectedTab == index) Color.White else Color(0xFFB7BBC3)
                    )
                },
                label = { Text(label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = RedPrimary,
                    unselectedIconColor = Color(0xFFB7BBC3),
                    unselectedTextColor = Color(0xFFB7BBC3),
                    indicatorColor = RedPrimary.copy(alpha = 0.18f),
                )
            )
        }
    }
}
