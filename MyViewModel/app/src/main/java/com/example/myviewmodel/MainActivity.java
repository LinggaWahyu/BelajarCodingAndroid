package com.example.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyButton myButton;
    private MyEditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.my_button);
        myEditText = findViewById(R.id.my_edit_text);

        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setMyEnableButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, myEditText.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setMyEnableButton() {
        Editable result = myEditText.getText();
        if (result != null && !result.toString().isEmpty()) {
            myButton.setEnabled(true);
        } else {
            myButton.setEnabled(false);
        }
    }
}
