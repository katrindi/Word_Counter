package com.example.word_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import utils.TextCounter;
import utils.WordsCounter;

public class MainActivity extends AppCompatActivity {

    private Spinner spSelectionOptions;
    private EditText edPhrase;
    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edPhrase = findViewById(R.id.edPhrase);
        this.tvMain = findViewById(R.id.tvMain);

         this.spSelectionOptions = (Spinner) findViewById(R.id.spSelectionOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectionOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        if(TextUtils.isEmpty(edPhrase.getText().toString())){
            Toast.makeText(MainActivity.this,
                    "Empty field not allowed!",
                    Toast.LENGTH_SHORT).show();
        }
        else if(this.spSelectionOptions.getSelectedItem().toString().equals(getResources().getString(R.string.chars_selection))) {
            this.tvMain.setText(TextCounter.getCharsCount(this.edPhrase.getText().toString()));
        }
        else
            this.tvMain.setText(WordsCounter.getWordsCount(this.edPhrase.getText().toString()));
    }
}