package com.dimka.tabsbus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Badgeable;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

public class MainActivity extends AppCompatActivity {
    private Drawer.Result drawerResult;
    private TextView mTextTab1;
    private TextView mTextTab2;
    TextView tvInfo;
    SharedPreferences sp;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_136pos:
                    setTitle(R.string.title_home);
                    mTextTab1.setText("home");
                    mTextTab2.setText("home");
                    return true;
                case R.id.navigation_176:
                    mTextTab1.setText("dashboard");
                    mTextTab2.setText("dashboard 2");
                    return true;
                case R.id.navigation_157pos:
                    mTextTab1.setText("notifications");
                    mTextTab2.setText("notifications 2");
                    return true;
                case R.id.navigation_136kmr:
                    mTextTab1.setText("notifications");
                    mTextTab2.setText("notifications 2");
                    return true;
                case R.id.navigation_157kmr:
                    mTextTab1.setText("notifications");
                    mTextTab2.setText("notifications 2");
                    return true;
//                case R.id.navigation_114:
//                    mTextTab1.setText("notifications");
//                    mTextTab2.setText("notifications 2");
//                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //боковое меню
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeNavigationDrawer(toolbar);


        //настройки
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        // получаем SharedPreferences, которое работает с файлом настроек
        sp = PreferenceManager.getDefaultSharedPreferences(this);


        //табы

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        // инициализация
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        // создаем вкладку и указываем тег
        tabSpec = tabHost.newTabSpec("tag1");
        // название вкладки
        tabSpec.setIndicator(getString(R.string.tabBudny));
        // указываем id компонента из FrameLayout, он и станет содержимым
        tabSpec.setContent(R.id.tvTab1);
        // добавляем в корневой элемент
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator(getString(R.string.tabVih));
        tabSpec.setContent(R.id.tvTab2);
        tabHost.addTab(tabSpec);


        // вторая вкладка будет выбрана по умолчанию
        tabHost.setCurrentTabByTag("tag1");

        // обработчик переключения вкладок
        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                Toast.makeText(getBaseContext(), "tabId = " + tabId, Toast.LENGTH_SHORT).show();
            }
        });


        mTextTab1 = (TextView) findViewById(R.id.tvTab1);
        mTextTab2 = (TextView) findViewById(R.id.tvTab2);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {

        if (drawerResult != null && drawerResult.isDrawerOpen()) {
            drawerResult.closeDrawer();
        }else{
        super.onBackPressed();}
    }

    private void initializeNavigationDrawer(Toolbar toolbar) {
        drawerResult = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
//                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home).withBadge("99").withIdentifier(1),
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_free_play).withIcon(FontAwesome.Icon.faw_gamepad),
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_custom).withIcon(FontAwesome.Icon.faw_eye).withBadge("6").withIdentifier(2),
//                        new SectionDrawerItem().withName(R.string.drawer_item_settings),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_cog),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIcon(FontAwesome.Icon.faw_question).setEnabled(false),
//                        new DividerDrawerItem(),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_github).withBadge("12+").withIdentifier(1)
                        new PrimaryDrawerItem()
                                .withName(R.string.setting)
                                .withIdentifier(1),

                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName(R.string.app_name)

                )

                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {

                        if (drawerItem instanceof Nameable) {
//                            Toast.makeText(MainActivity.this,MainActivity.this.getString(((Nameable) drawerItem).getNameRes()), Toast.LENGTH_SHORT).show();

                            switch (MainActivity.this.getString(((Nameable) drawerItem).getNameRes())){
                                case "Настройка":
                                    Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                                    startActivity(intent);
                                    break;
                                case "TabsBus":
                                    Toast.makeText(MainActivity.this, "vtoraya", Toast.LENGTH_SHORT).show();
                                    break;


                            }


                        }
                        if (drawerItem instanceof Badgeable) {
                            Badgeable badgeable = (Badgeable) drawerItem;
                            if (badgeable.getBadge() != null) {
                                // учтите, не делайте так, если ваш бейдж содержит символ "+"
                                try {
                                    int badge = Integer.valueOf(badgeable.getBadge());
                                    if (badge > 0) {
                                        drawerResult.updateBadge(String.valueOf(badge - 1), position);
                                    }
                                } catch (Exception e) {
                                    Log.d("test", "Не нажимайте на бейдж, содержащий плюс! :)");
                                }
                            }
                        }
                    }




//                        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
//                        startActivity(intent);

                })
                .build();
    }

    protected void onResume() {
        String listValue = sp.getString("list", "не выбрано");
        tvInfo.setText("Значение списка - " + listValue);
        super.onResume();
    }

//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuItem mi = menu.add(0, 1, 0, "Preferences");
//        mi.setIntent(new Intent(this, SettingActivity.class));
//        return super.onCreateOptionsMenu(menu);
//    }

//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuItem mi = menu.add(0, 1, 0, "Preferences");
//        mi.setIntent(Intent intent = new Intent(this, PrefActivity.class));
//        startActivity(intent);
//        return super.onCreateOptionsMenu(menu);
//    }


}
