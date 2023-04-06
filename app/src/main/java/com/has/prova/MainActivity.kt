package com.has.prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calButton: Button = findViewById(R.id.calcdate)
        calButton.setOnClickListener { val toast = Toast.makeText(this, "Esse e seu signo!", Toast.LENGTH_SHORT)
            toast.show()
        }
        fun extractDateParts(dateString: String): Pair<Int, Int> {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val date = dateFormat.parse(dateString)

            val calendar = Calendar.getInstance()
            calendar.time = date

            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH) + 1

            return Pair(day, month)
        }
        val dateString = "20/01/1990"
        val (day, month) = extractDateParts(dateString)
        println("Dia: $day, Mês: $month")

        fun getSigno() {
            val dataText: TextView = findViewById(R.id.datatext)
            val dataString = dataText.text.toString()
            val (day, month) = extractDateParts(dataString)

            val signo = when (month) {
                1 -> if (day <= 20) "Capricórnio" else "Aquário"
                2 -> if (day <= 19) "Aquário" else "Peixes"
                3 -> if (day <= 20) "Peixes" else "Áries"
                4 -> if (day <= 20) "Áries" else "Touro"
                5 -> if (day <= 20) "Touro" else "Gêmeos"
                6 -> if (day <= 20) "Gêmeos" else "Câncer"
                7 -> if (day <= 22) "Câncer" else "Leão"
                8 -> if (day <= 22) "Leão" else "Virgem"
                9 -> if (day <= 22) "Virgem" else "Libra"
                10 -> if (day <= 22) "Libra" else "Escorpião"
                11 -> if (day <= 21) "Escorpião" else "Sagitário"
                else -> if (day <= 21) "Sagitário" else "Capricórnio"
            }

            val signoImage: ImageView = findViewById(R.id.imagesign)
            val resourceId = when (signo) {
                "Áries" -> R.drawable.sign_3
                "Touro" -> R.drawable.sign_4
                "Gêmeos" -> R.drawable.sign_5
                "Câncer" -> R.drawable.sign_6
                "Leão" -> R.drawable.sign_7
                "Virgem" -> R.drawable.sign_8
                "Libra" -> R.drawable.sign_9
                "Escorpião" -> R.drawable.sign_10
                "Sagitário" -> R.drawable.sign_11
                "Capricórnio" -> R.drawable.sign_12
                "Peixes" -> R.drawable.sign_2
                else -> R.drawable.sign_1
            }

            Toast.makeText(this, "Seu signo é ", Toast.LENGTH_SHORT).show()
        }



































        /*fun getdate(){
                val data: TextView = findViewById(R.id.datatext)
                val format = SimpleDateFormat("dd/MM/yyyy")
                val datasigno = format.parse(data.toString())
                if(datasigno)
            }
        }

        private fun rollDice() {
            val dice = Dice(6)
            val diceRoll = dice.roll()
            val diceImage: ImageView = findViewById(R.id.imagesign)
            val drawableResource = when (diceRoll) {
                1 -> R.drawable.sign_1
                2 -> R.drawable.sign_2
                3 -> R.drawable.sign_3
                4 -> R.drawable.sign_4
                5 -> R.drawable.sign_5
                6 -> R.drawable.sign_6
                7 -> R.drawable.sign_7
                8 -> R.drawable.sign_8
                9 -> R.drawable.sign_9
                10 -> R.drawable.sign_10
                11 -> R.drawable.sign_11
                else -> R.drawable.sign_12
            }
            diceImage.setImageResource(drawableResource)
            diceImage.contentDescription = diceRoll.toString()


        }*/
 }
}