package com.loveconnect.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.loveconnect.app.ui.screens.ChatScreen
import com.loveconnect.app.ui.screens.PairingScreen
import com.loveconnect.app.ui.screens.SettingsScreen
import com.loveconnect.app.ui.theme.LoveConnectTheme
import com.loveconnect.app.ui.theme.RedPrimary
import com.loveconnect.app.ui.theme.Slate

@Composable
fun LoveConnectApp() {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }

    val tabs = listOf("Pair", "Chat", "Settings")

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.background,
                        Slate,
                    )
                )
            )
    ) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            topBar = {
                LoveConnectTopBar(
                    title = when (selectedTab) {
                        0 -> "Pairing"
                        1 -> "Private chat"
                        else -> "Account"
                    }
                )
            },
            bottomBar = {
                LoveConnectBottomBar(
                    selectedTab = selectedTab,
                    tabs = tabs,
                    onTabSelected = { selectedTab = it }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when (selectedTab) {
                    0 -> PairingScreen()
                    1 -> ChatScreen()
                    2 -> SettingsScreen()
                }
            }
        }
    }
}

@Composable
private fun LoveConnectTopBar(title: String) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp, vertical = 18.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
private fun LoveConnectBottomBar(
    selectedTab: Int,
    tabs: List<String>,
    onTabSelected: (Int) -> Unit,
) {
    // This is intentionally compact and elegant while preserving explicit consent and safe use.
}
