package com.loveconnect.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BatteryChargingFull
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.VideoCameraBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.loveconnect.app.ui.theme.CardDark
import com.loveconnect.app.ui.theme.RedPrimary
import com.loveconnect.app.ui.theme.RedSoft
import com.loveconnect.app.ui.theme.SoftGray

@Composable
fun PairingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = CardDark),
            shape = RoundedCornerShape(28.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(88.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.radialGradient(
                                listOf(
                                    RedSoft,
                                    RedPrimary,
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = androidx.compose.material.icons.Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Text(
                    text = "Love Connect",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Text(
                    text = "Your private pairing code",
                    color = SoftGray,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Box(
                    modifier = Modifier
                        .padding(top = 18.dp)
                        .fillMaxWidth()
                        .height(72.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(Color(0xFF0F1116))
                        .border(1.dp, RedPrimary.copy(alpha = 0.55f), RoundedCornerShape(18.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "483219",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    StatusPill(label = "Online", active = true)
                    StatusPill(label = "Battery 87%", active = false)
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = CardDark),
            shape = RoundedCornerShape(26.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Connect securely",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
                PairRow("Primary user", "Partner ready")
                PairRow("Session status", "Verified")
                PairRow("Permission status", "Consent required")
            }
        }
    }
}

@Composable
private fun PairRow(title: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, color = SoftGray)
        Text(text = value, fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun StatusPill(label: String, active: Boolean) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(if (active) RedPrimary.copy(alpha = 0.18f) else Color(0xFF1D2027))
            .padding(horizontal = 12.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = if (active) RedSoft else SoftGray,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun ChatScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ChatHeader()

        MessageBubble(
            text = "Hey love, are we still meeting later?",
            isMe = false,
            time = "09:14"
        )
        MessageBubble(
            text = "Yes, I’m free after 8. Want to walk together?",
            isMe = true,
            time = "09:15"
        )
        MessageBubble(
            text = "Perfect. I’ll share my location only if you approve it.",
            isMe = false,
            time = "09:15"
        )
        MessageBubble(
            text = "Approved. I’ll keep camera sharing turned off until you tap allow.",
            isMe = true,
            time = "09:16"
        )
    }
}

@Composable
private fun ChatHeader() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = CardDark)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(RedPrimary),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(22.dp)
                    )
                }
                Column(modifier = Modifier.padding(start = 12.dp)) {
                    Text(text = "Ava", style = MaterialTheme.typography.titleMedium)
                    Text(text = "Online • battery 87%", color = SoftGray)
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(Icons.Default.BatteryChargingFull, contentDescription = null, tint = RedSoft)
                Icon(Icons.Default.LocationOn, contentDescription = null, tint = RedSoft)
                Icon(Icons.Default.VideoCameraBack, contentDescription = null, tint = RedSoft)
            }
        }
    }
}

@Composable
private fun MessageBubble(text: String, isMe: Boolean, time: String) {
    val alignment = if (isMe) Alignment.End else Alignment.Start
    Column(horizontalAlignment = alignment, modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(if (isMe) RedPrimary else CardDark)
                .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
            Text(text = text, color = Color.White)
        }
        Text(
            text = time,
            color = SoftGray,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        PermissionTile(
            title = "Location sharing",
            subtitle = "Visible approval required before sharing live location.",
            isEnabled = true
        )
        PermissionTile(
            title = "Camera sharing",
            subtitle = "Only share video when both users tap allow.",
            isEnabled = false
        )
        PermissionTile(
            title = "Disconnect session",
            subtitle = "End the current pairing and revoke access from this device.",
            isEnabled = false
        )
    }
}

@Composable
private fun PermissionTile(title: String, subtitle: String, isEnabled: Boolean) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = CardDark),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(text = subtitle, color = SoftGray, modifier = Modifier.padding(top = 6.dp))
            }
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(if (isEnabled) RedPrimary else Color(0xFF242A31))
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (isEnabled) Icons.Default.Lock else Icons.Default.VideoCameraBack,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
