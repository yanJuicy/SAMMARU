package com.example.sammaru.delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.sammaru.LookUpFragment;
import com.example.sammaru.R;
import com.example.sammaru.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * 기사 메인 액티비티
 * 이 액티비티는 2개의 프래그먼트를 포함한다
 * 1. 고객 목록 프래그먼트, 2. 설정 프래그먼트
 *
 */

public class DeliveryMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_main);

        // 네비게이션 뷰 클릭 이벤트
        BottomNavigationView navView = findViewById(R.id.delivery_main_activity_navigation);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.action_customer_list:
                        fragment = new CustomerListFragment();
                        break;
                    case R.id.action_settings:
                        fragment = new SettingFragment();
                        break;
                    case R.id.action_lookup:
                        fragment = new LookUpFragment();
                        break;
                    case R.id.action_products_list:
                        fragment = new ProductListFragment();
                        break;
                }
                return loadFragment(fragment);
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.delivery_main_activity_framelayout, new CustomerListFragment()).commit();
    }

    // 네비게이션 뷰 클릭시 해당하는 프래그먼트 로딩
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.delivery_main_activity_framelayout, fragment).commit();
            return true;
        }
        return false;
    }
}
