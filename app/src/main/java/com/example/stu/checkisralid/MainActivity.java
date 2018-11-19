package com.example.stu.checkisralid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    TextView textView;
    String text;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        editText = findViewById(R.id.editText);
         textView = findViewById(R.id.textView);
         findViewById(R.id.delete).setOnClickListener(this);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                text = editText.getText().toString();
                if (text.length() == 8){
                    textView.setText(R.string.Enter_9_numbers);
                    imageView.setImageResource(0);
                }
                else if(text.length()>8){
                    textView.setText("");

                if (checkId(text)){
                    imageView.setImageResource(R.drawable.check_icon);
                }else {
                    imageView.setImageResource(R.drawable.x_check_icon);

                }
                }
            }
        });
    }





    public void onClick(View view) {
        editText.getText().clear();
        textView.setText("");
        imageView.setImageResource(0);
    }

    public boolean checkId(String id){
        if (String.valueOf(id).length()<9){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0){
                sum += Integer.valueOf(id.substring(i, i + 1));
            }else {
                int num = Integer.valueOf(id.substring(i, i + 1)) * 2;
                String numToStr = String.valueOf(num);
                if (numToStr.length()>1){
                    int number = Integer.valueOf(numToStr.substring(0, 1)) + Integer.valueOf(numToStr.substring(1));
                    sum += number;
                }else {
                    sum += num;
                }
            }
        }
        return sum  % 10 == 0;
    }
}
