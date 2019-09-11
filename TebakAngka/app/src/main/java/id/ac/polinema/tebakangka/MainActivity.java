package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

	//  TODO: deklarasikan variabel di sini

	EditText inputNumber;
	int randomNumber;
	Button tebakButton;
	Button resetButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini

		inputNumber = findViewById(R.id.number_input);
		tebakButton = findViewById(R.id.guess_button);
		resetButton = findViewById(R.id.reset_button);

		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber()
	{
		Random angkaRandom = new Random();
		randomNumber = 1 + angkaRandom.nextInt((100 - 1) + 1);

	}

	public void handleGuess(View view)
	{
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		if (!inputNumber.getText().toString().equals("-") && !inputNumber.getText().toString().equals(""))
		{
			int input = Integer.parseInt(inputNumber.getText().toString());
			if (input < randomNumber)
			{
				Toast.makeText(this, "Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
			}
			else if (input > randomNumber)
			{
				Toast.makeText(this, "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, "Tebakan anda benar!", Toast.LENGTH_SHORT).show();
				tebakButton.setEnabled(false);
			}
		}
		else
		{
			Toast.makeText(this, "Masukkan angka yang ditebak!", Toast.LENGTH_SHORT).show();
		}
	}

	public void handleReset(View view)
	{
		// TODO: Reset tampilan
		initRandomNumber();
		inputNumber.setText("");
		tebakButton.setEnabled(true);
	}
}
