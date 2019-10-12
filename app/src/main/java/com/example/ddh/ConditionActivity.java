package com.example.ddh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.ddh.service.JobSchedulerStart;

public class ConditionActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition);

        ImageView ivGood = findViewById(R.id.condition_good);
        ImageView ivSoso = findViewById(R.id.condition_soso);
        ImageView ivBad = findViewById(R.id.condition_bad);

        ivGood.setOnClickListener(this);
        ivSoso.setOnClickListener(this);
        ivBad.setOnClickListener(this);
        JobSchedulerStart.start(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.condition_good:
            case R.id.condition_soso:
            case R.id.condition_bad:
                startActivity(new Intent(ConditionActivity.this, MainActivity.class));
                finish();
                break;
        }
    }
}
