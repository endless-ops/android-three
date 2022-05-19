package cn.dreamchase.android.three.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import cn.dreamchase.android.three.R;

public class MainActivity_Dynamic extends AppCompatActivity {

    private FragmentContainer fragmentContainer_1;
    private FragmentContainer fragmentContainer_2;
    private FragmentContainer fragmentContainer_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dynamic);

        fragmentContainer_1 = FragmentContainer.getInstance(1);
        fragmentContainer_2 = FragmentContainer.getInstance(2);
        fragmentContainer_3 = FragmentContainer.getInstance(3);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fl_container,fragmentContainer_1);
                transaction.add(R.id.fl_container,fragmentContainer_2);
                transaction.commit();
            }
        });


        findViewById(R.id.btn_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragmentContainer_2);
                transaction.commit();
            }
        });

        findViewById(R.id.btn_replace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_container,fragmentContainer_3);
                transaction.commit();
            }
        });

        findViewById(R.id.btn_hide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.hide(fragmentContainer_3);
                transaction.commit();
            }
        });

        findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.show(fragmentContainer_3);
                transaction.commit();
            }
        });

    }
}