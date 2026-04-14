package com.audiobasics.desk.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PairingScreen(onPaired: () -> Unit) {
    var code by remember { mutableStateOf("") }
    val isCodeValid = code.length == 6

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.widthIn(max = 400.dp)
        ) {
            // App name
            Text(
                text = "Audiobasics Desk",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Open Audiobasics on your phone and tap\nDesk → Pair New Device",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(8.dp))

            // QR code placeholder box
            Box(
                modifier = Modifier
                    .size(180.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "QR Code\n(coming soon)",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Divider
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                HorizontalDivider(modifier = Modifier.weight(1f))
                Text("  or enter code  ", color = MaterialTheme.colorScheme.onSurfaceVariant)
                HorizontalDivider(modifier = Modifier.weight(1f))
            }

            // Code input
            OutlinedTextField(
                value = code,
                onValueChange = { if (it.length <= 6) code = it.uppercase() },
                label = { Text("6-digit pairing code") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { if (isCodeValid) onPaired() },
                enabled = isCodeValid,
                modifier = Modifier.fillMaxWidth().height(48.dp)
            ) {
                Text("Connect")
            }
        }
    }
}
