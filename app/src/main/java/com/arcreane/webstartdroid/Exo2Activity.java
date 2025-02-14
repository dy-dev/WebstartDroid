package com.arcreane.webstartdroid;

import static android.widget.Toast.LENGTH_LONG;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Exo2Activity extends AppCompatActivity {

    EDifficulty m_eGameDifficulty;
    int m_iRandomNumberToGuess;
    EditText guessEditText;
    Button validateGuess;
    TextView hintTextView;
    ListView lv;
    ProgressBar progress_bar;
    TextView progress_textView;
    TextView scoreTextView;
    ArrayList<Result> results;
    int m_iScore = 0;

    class Result {
        int a;
        String b;

        public Result(int a, String b) {
            this.a = a;
            this.b = b;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo2);
        guessEditText = findViewById(R.id.guessEditText);
        validateGuess = findViewById(R.id.validateGuess);
        guessEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validateGuess.setEnabled(guessEditText.getText().length() > 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        hintTextView = findViewById(R.id.hintTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        lv = findViewById(R.id.hintListView);
        progress_bar = findViewById(R.id.progress_bar);
        progress_textView = findViewById(R.id.progress_textView);

        results = new ArrayList();


        ArrayAdapter<Result> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, android.R.id.text1, results) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);

                text1.setText("" + results.get(position).a);
                text2.setText(results.get(position).b);

                return view;
            }
        };
        lv.setAdapter(adapter);

        validateGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userGuess = Integer.valueOf(guessEditText.getText().toString());
                results.add(0, new Result(userGuess, hintTextView.getText().toString()));

                if (userGuess == m_iRandomNumberToGuess) {
                    Toast.makeText(Exo2Activity.this, "Congrats", LENGTH_LONG).show();
                    hintTextView.setText("CORRECT !!!");
                    reset(false);
                } else if (userGuess < m_iRandomNumberToGuess)
                    hintTextView.setText("Too Small");
                else
                    hintTextView.setText("Too Big");

                lv.invalidateViews();
                progress_bar.setProgress(progress_bar.getProgress() + 1);
                progress_textView.setText("" + progress_bar.getProgress());
                if (progress_bar.getProgress() == progress_bar.getMax()) {
                    Toast.makeText(Exo2Activity.this, "You Lost, try again", LENGTH_LONG).show();
                    reset(true);
                }

            }
        });


    }

    private void reset(boolean p_bLost) {
        results.clear();
        guessEditText.setText("");
        hintTextView.setText("");
        if (p_bLost)
            m_iScore = 0;
        else
            m_iScore += progress_bar.getMax() - progress_bar.getProgress();

        scoreTextView.setText("" + m_iScore);
        progress_bar.setProgress(0);
        progress_textView.setText("" + 0);
    }


    public void selectDiff(View view) {
        RadioButton rb = (RadioButton) view;

        String tag = rb.getTag().toString();

        m_eGameDifficulty = EDifficulty.valueOf(tag.toUpperCase());

        Button validation = findViewById(R.id.validate);
        validation.setEnabled(true);
    }


    public void validateDiff(View view) {
        LinearLayout diffLayout = findViewById(R.id.difficultyLayout);
        diffLayout.setVisibility(View.GONE);

        LinearLayout gameLayout = findViewById(R.id.gameLayout);
        gameLayout.setVisibility(View.VISIBLE);

        Random rand = new Random();
        m_iRandomNumberToGuess = rand.nextInt(0, m_eGameDifficulty.getValue());

        Toast.makeText(Exo2Activity.this, "" + m_iRandomNumberToGuess, LENGTH_LONG).show();

    }

}