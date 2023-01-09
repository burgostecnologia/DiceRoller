package com.burgostecnologiabr.diceroller


import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.burgostecnologiabr.diceroller.ui.theme.DiceRollerTheme
import java.lang.Math.log
import java.util.logging.Level.INFO
import java.util.logging.Logger

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp(this)
            }
        }
    }
}

@Composable
fun DiceRollerApp(context: Context){
    val mpone: MediaPlayer = MediaPlayer.create(context,R.raw.onedice)
    val mpmore: MediaPlayer = MediaPlayer.create(context,R.raw.moredices)
    DiceImageButton(Modifier,mpone,mpmore)
}

//@Preview
@Composable
fun DiceImageButton(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center), m1: MediaPlayer,m2: MediaPlayer
    )
{

    var resultDefence1 by remember {
        mutableStateOf(1)
    }
    var resultDefence2 by remember {
        mutableStateOf(1)
    }
    var resultDefence3 by remember {
        mutableStateOf(1)
    }
    var resultAttack1 by remember {
        mutableStateOf(1)
    }
    var resultAttack2 by remember {
        mutableStateOf(1)
    }
    var resultAttack3 by remember {
        mutableStateOf(1)
    }

    var imageResourceDefenceA1 =
        when(resultDefence1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else  -> R.drawable.dice_6
        }
    var imageResourceDefenceA2 =
        when(resultDefence2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else  -> R.drawable.dice_6
        }
    var imageResourceDefenceA3 =
        when(resultDefence3){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else  -> R.drawable.dice_6
        }

    var imageResourceAttackV1 =
        when(resultAttack1){
            1 -> R.drawable.vdice_1
            2 -> R.drawable.vdice_2
            3 -> R.drawable.vdice_3
            4 -> R.drawable.vdice_4
            5 -> R.drawable.vdice_5
            else  -> R.drawable.vdice_6
        }
    var imageResourceAttackV2 =
        when(resultAttack2){
            1 -> R.drawable.vdice_1
            2 -> R.drawable.vdice_2
            3 -> R.drawable.vdice_3
            4 -> R.drawable.vdice_4
            5 -> R.drawable.vdice_5
            else  -> R.drawable.vdice_6
        }
    var imageResourceAttackV3 =
        when(resultAttack3){
            1 -> R.drawable.vdice_1
            2 -> R.drawable.vdice_2
            3 -> R.drawable.vdice_3
            4 -> R.drawable.vdice_4
            5 -> R.drawable.vdice_5
            else  -> R.drawable.vdice_6
        }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally )
    {
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {  m1.start(); resultAttack1 = (1..6).random()  }) {
            Text(text = stringResource(R.string.attack1),
                modifier = Modifier.width(200.dp),
                textAlign = TextAlign.Center)

            //Log.d("dado", "Dentro botao Result: $result")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {  m2.start(); resultAttack1 = (1..6).random(); resultAttack2 = (1..6).random() }) {
            Text(text = stringResource(R.string.attack2),
                modifier = Modifier.width(200.dp),
                textAlign = TextAlign.Center)
            //Log.d("dado", "Dentro botao Result: $result")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {  m2.start(); resultAttack1 = (1..6).random(); resultAttack2 = (1..6).random(); resultAttack3 = (1..6).random() }) {
            Text(text = stringResource(R.string.attack3),
                modifier = Modifier.width(200.dp),
                textAlign = TextAlign.Center)
            //Log.d("dado", "Dentro botao Result: $result")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row{
            Image(
                painter = painterResource(imageResourceAttackV1),
                contentDescription = resultAttack1.toString(),
                modifier = Modifier
                    .size(128.dp)
                    .clickable {  m1.start(); resultAttack1 = (1..6).random() }
            )
            Image(
                painter = painterResource(imageResourceAttackV2),
                contentDescription = resultAttack2.toString(),
                modifier = Modifier
                    .size(128.dp)
                    .clickable {  m1.start(); resultAttack2 = (1..6).random() }
            )
            Image(
                painter = painterResource(imageResourceAttackV3),
                contentDescription = resultAttack3.toString(),
                modifier = Modifier
                    .size(128.dp)
                    .clickable {  m1.start(); resultAttack3 = (1..6).random() }
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clickable { resultDefence1 = 1; resultDefence2 = 1; resultDefence3 = 1;  resultAttack1 = 1; resultAttack2 = 1; resultAttack3 = 1; }
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row{
            Image(
                painter = painterResource(imageResourceDefenceA1),
                contentDescription = resultDefence1.toString(),
                modifier = Modifier
                    .size(128.dp)
                    .clickable {  m1.start();  resultDefence1 = (1..6).random() }
            )
            Image(
                painter = painterResource(imageResourceDefenceA2),
                contentDescription = resultDefence2.toString(),
                modifier = Modifier
                    .size(128.dp)
                    .clickable {  m1.start(); resultDefence2 = (1..6).random() }
            )
            Image(
                painter = painterResource(imageResourceDefenceA3),
                contentDescription = resultDefence3.toString(),
                modifier = Modifier
                    .size(128.dp)
                    .clickable {  m1.start(); resultDefence3 = (1..6).random() }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {  m2.start(); resultDefence1= (1..6).random(); resultDefence2= (1..6).random(); resultDefence3= (1..6).random() }  ) {
            Text(text = stringResource(R.string.defence3),
                modifier = Modifier.width(200.dp),
                textAlign = TextAlign.Center)
            //Log.d("dado", "Dentro botao Result: $result")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {  m2.start(); resultDefence1= (1..6).random(); resultDefence2= (1..6).random() }  ) {
            Text(text = stringResource(R.string.defence2),
                modifier = Modifier.width(200.dp),
                textAlign = TextAlign.Center)
            //Log.d("dado", "Dentro botao Result: $result")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {  m1.start(); resultDefence1= (1..6).random() }  ) {
            Text(text = stringResource(R.string.defence1),
                modifier = Modifier.width(200.dp),
                textAlign = TextAlign.Center)
            //Log.d("dado", "Dentro botao Result: $result")
        }
        Spacer(modifier = Modifier.height(8.dp))
    }


}
