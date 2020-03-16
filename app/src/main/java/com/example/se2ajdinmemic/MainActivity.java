package com.example.se2ajdinmemic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {


        TextView textView2 = (TextView) findViewById(R.id.textView2);
        EditText editText = (EditText) findViewById(R.id.editText);
        int number = Integer.parseInt(editText.getText().toString());

        int[] arr = new int[8];
        int odd = 0; //Wie viele ungeraden Zahlen habe ich im Array?
        int even = 0;//Wie viele gerade Zahlen habe ich im Array?

        int div = 0;
        do {
            arr[div] = number % 10;
            number /= 10;
            div++;
        } while (number != 0);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        int[] odd_arr = new int[odd];
        int[] even_arr = new int[even];
        int odd_index = 0;
        int even_index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even_arr[even_index] = arr[i];
                even_index++;
            } else {
                odd_arr[odd_index] = arr[i];
                odd_index++;
            }
        }

        odd_arr = returnSortedArr(odd_arr);
        even_arr = returnSortedArr(even_arr);

        String s = "";
        for (int i = 0; i < even_arr.length; i++) {
            s += String.valueOf(even_arr[i] + " ");
        }

        for (int i = 0; i < odd_arr.length; i++) {
            s += String.valueOf(odd_arr[i] + " ");
        }

        textView2.setText(s);
    }
    public static int[] returnSortedArr(int[] arr) {
        int temp = 0;
        for (int z = 0; z < arr.length; z++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
        return arr;
    }
}
