package com.example.bnimobilebanking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bnimobilebanking.ui.theme.BniMobileBankingTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BniMobileBankingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun TransactionHistoryScreen() {
    Column(modifier = Modifier.fillMaxWidth().background(Color.White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Riwayat Transaksi", style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold))
            Text(text = "See All", style = MaterialTheme.typography.bodyLarge.copy(color = Color(0xFF005E68)))
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
        ) {
            FilterButton(text = "Semua", isSelected = true)
            FilterButton(text = "1 Hari", isSelected = false)
            FilterButton(text = "1 Minggu", isSelected = false)
            FilterButton(text = "1 Bulan", isSelected = false)
        }

        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "Hari Ini",
                style = MaterialTheme.typography.displayMedium.copy(color = Color.Black),
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
            TransactionItem("Transfer", "BCA 927637826", "-Rp. 540.000", Color.White)
            TransactionItem("Dana Masuk", "BANK MANDIRI 1124562321", "+Rp. 100.000", Color.White)
            Text(
                text = "Kamis, 20 Maret 2024",
                style = MaterialTheme.typography.displayMedium.copy(color = Color.Black),
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
            TransactionItem("Tarik Tunai", "7637629674", "-Rp. 100.000", Color.White)
            TransactionItem("QRIS", "1242351223", "-Rp. 100.000", Color.White)
        }
    }
}

@Composable
fun FilterButton(text: String, isSelected: Boolean) {
    TextButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            contentColor = if (isSelected) Color.White else Color.Black
        ),
        shape = RoundedCornerShape(50)
    ) {
        Text(text = text)
    }
}

@Composable
fun TransactionItem(title: String, subtitle: String, amount: String, backgroundColor: Color) {
    Column(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .background(backgroundColor, RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Text(
                text = amount,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = if (amount.startsWith("-")) Color.Red else Color.Green,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.logobni),
            contentDescription = "logo",
            modifier = Modifier.size(80.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(text = "Saldo Tersedia", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Rp. 42,242,000", style = MaterialTheme.typography.displayMedium.copy(fontSize = 25.sp))
            }
            Spacer(modifier = Modifier.width(30.dp))
            Image(
                painter = painterResource(R.drawable.profile_pict),
                contentDescription = "profile picture",
                modifier = Modifier.size(70.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "BNI TAPLUS MUDA",
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontSize = 15.sp,
                        color = Color(0xFF005E68)
                    )
                )
                Text(
                    text = "7637629674",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            FeatureItem(R.drawable.transfer, "Transfer", Color(0x232FB0B6B7))
            FeatureItem(R.drawable.qr, "QRIS", Color(0xFFB0B6B7))
            FeatureItem(R.drawable.riwayat, "Riwayat", Color(0xFFF15A23))
            FeatureItem(R.drawable.rekeningku, "RekeningKu", Color(0xFFB0B6B7))
        }

        Spacer(modifier = Modifier.height(16.dp))

        TransactionHistoryScreen()
    }
}

@Composable
fun FeatureItem(imageRes: Int, label: String, backgroundColor: Color) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(backgroundColor, RoundedCornerShape(15.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = label,
                modifier = Modifier.size(40.dp)
            )
        }
        Text(
            text = label,
            style = MaterialTheme.typography.displayMedium.copy(fontSize = 15.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    BniMobileBankingTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            MainScreen()
        }
    }
}



