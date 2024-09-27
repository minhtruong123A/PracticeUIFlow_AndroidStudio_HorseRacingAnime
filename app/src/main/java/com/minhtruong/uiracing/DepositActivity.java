package com.minhtruong.uiracing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class DepositActivity extends AppCompatActivity {

    private EditText etDepositAmount;
    private Button btnConfirmDeposit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deposit_activity);  // Load Deposit screen layout

        etDepositAmount = findViewById(R.id.et_deposit_amount);
        btnConfirmDeposit = findViewById(R.id.btn_confirm_deposit);

        // Confirm deposit and return result
        btnConfirmDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int depositedMoney = Integer.parseInt(etDepositAmount.getText().toString());
                Intent resultIntent = new Intent();
                resultIntent.putExtra("depositedMoney", depositedMoney);
                setResult(RESULT_OK, resultIntent);
                finish();  // Close activity and return result
            }
        });
    }
}
