package com.example.sumofprimenumber;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

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
                // Trong onClick: ngay sau khi đọc giá trị từ EditText → để xem input hoặc.
                Log.d("DEBUG", "Input = " + input);
                if (input.isEmpty()) {
                    txtResult.setText("Vui lòng nhập số!");
                    txtPrimes.setText("");
                    return;
                }

                int n = Integer.parseInt(input);
                // Sau khi parse sang int → kiểm tra n hoặc.
                Log.d("DEBUG", "Giá trị n = " + n);
                int sum = 0;
                StringBuilder primesList = new StringBuilder();

                for (int i = 2; i < n; i++) {
                    if (isPrime(i)) {
                    // Trong vòng lặp → để theo dõi từng số i và giá trị sum.
                        sum += i;
                        primesList.append(i).append(" ");
                        Log.d("DEBUG", "Thêm số nguyên tố " + i + ", tổng hiện tại = " + sum);
                    }
                }

                txtResult.setText("Tổng số nguyên tố nhỏ hơn " + n + " là: " + sum);
                txtPrimes.setText("Các số nguyên tố: " + primesList.toString());
                Log.d("DEBUG", "Kết quả cuối cùng: sum = " + sum + ", primes = " + primesList.toString());
            }
        });
    }
    // Hàm kiểm tra số nguyên tố
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
        // Trong hàm isPrime → để theo dõi logic kiểm tra.
            if (num % i == 0) {
                Log.d("DEBUG", num + " chia hết cho " + i + " → không phải số nguyên tố");
                return false;
            }
        }
        Log.d("DEBUG", num + " là số nguyên tố");
        return true;
    }
}
