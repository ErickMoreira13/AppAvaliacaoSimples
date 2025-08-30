package com.unir.widgets;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private Handler handler; // Handler da UI Thread
    private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Componente TextView e Button
        TextView textView = findViewById(R.id.txt_view);


        TextInputEditText textEdit= findViewById(R.id.txtEdit);
        EditText textMultiline= findViewById(R.id.txtMultiLine);

        //Manipulação do componente RatingBar
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setNumStars(5);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Nota selecionada: " + rating, Toast.LENGTH_SHORT).show();
            }
        });
        /*
        //Manipulação do componente ImageView
        ImageView imageView = findViewById(R.id.imageView);
        Button btn_imageView = findViewById(R.id.btn_imageView);
        btn_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.widget2);
            }
        });
         */

        //Manipulação do componente EditText
        Button btn_textInputEditText = findViewById(R.id.btn_enviar);
        btn_textInputEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                textEdit.setText("");
                textMultiline.setText("");
                Toast.makeText(MainActivity.this, "A sua avaliação foi enviada com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}