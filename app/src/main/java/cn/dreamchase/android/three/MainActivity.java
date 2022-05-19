package cn.dreamchase.android.three;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cn.dreamchase.android.three.navigator.DynamicFragment;
import cn.dreamchase.android.three.navigator.HomeFragment;
import cn.dreamchase.android.three.navigator.MessageFragment;
import cn.dreamchase.android.three.navigator.PersonFragment;

/**
 * -导航栏练习
 */
public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private DynamicFragment dynamicFragment;
    private MessageFragment messageFragment;
    private PersonFragment personFragment;


    private int currentId = R.id.main;

    private TextView main;
    private TextView dynamic;
    private TextView message;
    private TextView person;

    private static final int MAIN = R.id.main;
    private static final int DYNAMIC = R.id.dynamic;
    private static final int MESSAGE = R.id.message;
    private static final int PERSON = R.id.person;
    private static final int MAKE = R.id.make;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);
        main.setSelected(true);
        dynamic = findViewById(R.id.dynamic);
        message = findViewById(R.id.message);
        person = findViewById(R.id.person);

        // 默认加载首页
        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, homeFragment).commit();

        main.setOnClickListener(tabClickListener);
        dynamic.setOnClickListener(tabClickListener);
        message.setOnClickListener(tabClickListener);
        person.setOnClickListener(tabClickListener);
        findViewById(R.id.make).setOnClickListener(onClickListener);
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == MAKE) {
                Toast.makeText(MainActivity.this, "点击了制作按钮", Toast.LENGTH_SHORT).show();
            }
        }
    };


    private View.OnClickListener tabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() != currentId) {
                changeSelect(v.getId()); // 改变图标跟文字颜色的选中
                changeFragment(v.getId()); // fragment 的切换
                currentId = v.getId();   // 设置选中的 id
            }
        }
    };

    private void changeFragment(int resId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();   // 开启一个Fragment事务

        hideFragment(transaction); // 隐藏所有的fragment

        if (resId == R.id.main) {
            if (homeFragment == null) {
                // 如果为空先添加进来，不为空则直接显示
                homeFragment = new HomeFragment();
                transaction.add(R.id.main_container, homeFragment);
            } else {
                transaction.show(homeFragment);
            }
        } else if (resId == R.id.dynamic) {
            if (dynamicFragment == null) {
                // 如果为空先添加进来，不为空则直接显示
                dynamicFragment = new DynamicFragment();
                transaction.add(R.id.main_container, dynamicFragment);
            } else {
                transaction.show(dynamicFragment);
            }
        } else if (resId == R.id.message) {
            if (messageFragment == null) {
                // 如果为空先添加进来，不为空则直接显示
                messageFragment = new MessageFragment();
                transaction.add(R.id.main_container, messageFragment);
            } else {
                transaction.show(messageFragment);
            }
        } else if (resId == R.id.person) {
            if (personFragment == null) {
                // 如果为空先添加进来，不为空则直接显示
                personFragment = new PersonFragment();
                transaction.add(R.id.main_container, personFragment);
            } else {
                transaction.show(personFragment);
            }
        }

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (dynamicFragment != null) {
            transaction.hide(dynamicFragment);
        }

        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }

        if (personFragment != null) {
            transaction.hide(personFragment);
        }
    }

    /**
     * -选中改变颜色
     * @param resId
     */
    private void changeSelect(int resId) {
        main.setSelected(false);
        dynamic.setSelected(false);
        message.setSelected(false);
        person.setSelected(false);

        switch (resId) {
            case MAIN:
                main.setSelected(true);
                break;
            case DYNAMIC:
                dynamic.setSelected(true);
                break;
            case MESSAGE:
                message.setSelected(true);
                break;
            case PERSON:
                person.setSelected(true);
                break;
        }
    }
}