package com.example.hidemyvpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hidemyvpn.ui.theme.APPTheme

class MainActivity: ComponentActivity() {

    private var isSwitchOn = mutableStateOf(false)
    // VPN status can be "Connected", "Disconnected", "Unknown"
    private var vpnStatus = mutableStateOf("Unknown")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            APPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    AppUI(vpnStatus.value)
                }
            }
        }
    }

    @Composable
    fun AppUI(vpnStatus: String, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "HideMyVPN",
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )
                Switch(
                    // enabled = true, for testing
                    // TODO: set Switch enabled to True, If Xposed Module is Enabled else False
                    enabled = true,
                    checked = isSwitchOn.value,
                    onCheckedChange = {
                        isSwitchOn.value = it
                    },
                    modifier = Modifier.padding(10.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(30.dp)
            ){
                Text(
                    text = "VPN Status: ",
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = vpnStatus,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Unspecified // Can be changed based on VPN status
                )
            }
        }
    }
}