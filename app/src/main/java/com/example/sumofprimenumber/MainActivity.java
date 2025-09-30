package com.example.sumofprimenumber;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtNumber;
    Button btnCalculate;
    TextView txtResult, txtPrimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber = findViewById(R.id.edtNumber);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        txtPrimes = findViewById(R.id.txtPrimes);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = edtNumber.getText().toString().trim();
                if (input.isEmpty()) {
                    txtResult.setText("Vui lòng nhập số!");
                    txtPrimes.setText("");
                    return;
                }

                int n = Integer.parseInt(input);
                int sum = 0;
                StringBuilder primesList = new StringBuilder();

                for (int i = 2; i < n; i++) {
                    if (isPrime(i)) {
                        sum += i;
                        primesList.append(i).append(" ");
                    }
                }

                txtResult.setText("Tổng số nguyên tố nhỏ hơn " + n + " là: " + sum);
                txtPrimes.setText("Các số nguyên tố: " + primesList.toString());
            }
        });
    }

    // Hàm kiểm tra số nguyên tố
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
