package com.dimka.tabsbus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Badgeable;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

public class MainActivity extends AppCompatActivity {
    private Drawer.Result drawerResult;
    private TextView mTextTab1;
    private TextView mTextTab2;
    TextView tvInfo;
    SharedPreferences sp;
//    Menu menu;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_136pos:
                    setTitle(R.string.toolBar_136pos);
                    mTextTab1.setText(R.string.TextTime136pos);
                    mTextTab2.setText(R.string.TextTime136posVih);

                    return true;
                case R.id.navigation_176:
                    setTitle(R.string.toolBar_176);
                    mTextTab1.setText(R.string.TextTime176);
                    mTextTab2.setText(R.string.TextTime176Vih);
                    return true;
                case R.id.navigation_114:
                    setTitle(R.string.toolBar_114);
                    mTextTab1.setText(R.string.TextTime114);
                    mTextTab2.setText(R.string.TextTime114Vih);
                    return true;
                case R.id.navigation_136kmr:
                    setTitle(R.string.toolBar_136kmr);
                    mTextTab1.setText(R.string.TextTime136kmr);
                    mTextTab2.setText(R.string.TextTime136kmrVih);
                    return true;
                case R.id.navigation_157kmr:
                    setTitle(R.string.toolBar_157kmr);
                    mTextTab1.setText(R.string.TextTime157kmr);
                    mTextTab2.setText(R.string.TextTime157kmrVih);
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
//        mTextTab1.setText(R.string.TextTime136kmr);
        setTitle(R.string.toolBar_136kmr);
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
//        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
//            public void onTabChanged(String tabId) {
//                Toast.makeText(getBaseContext(), "tabId = " + tabId, Toast.LENGTH_SHORT).show();
//            }
//        });

        mTextTab1 = (TextView) findViewById(R.id.tvTab1);
        mTextTab2 = (TextView) findViewById(R.id.tvTab2);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_136pos);
    }

    @Override
    public void onBackPressed() {

        if (drawerResult != null && drawerResult.isDrawerOpen()) {
            drawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        // передаём ссылку на наш объект
//        this.menu = menu;
//        getMenuInflater().inflate(R.menu.navigation, menu);
//        return true;
//    }

    private void initializeNavigationDrawer(Toolbar toolbar) {
        drawerResult = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .withTranslucentStatusBar(false)
                .withTranslucentActionBarCompatibility(false)
                .withDrawerWidthPx(650)
//                .withDisplayBelowToolbar(true)


//                .withTranslucentNavigationBarProgrammatically(true)

//                .setTranslucentStatusFlag(true)

//                .withHeader(R.layout.drawer_header)
                .withSelectedItem(-1)
                .addDrawerItems(
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home).withBadge("99").withIdentifier(1),
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_free_play).withIcon(FontAwesome.Icon.faw_gamepad),
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_custom).withIcon(FontAwesome.Icon.faw_eye).withBadge("6").withIdentifier(2),
//                        new SectionDrawerItem().withName(R.string.drawer_item_settings),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_cog),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIcon(FontAwesome.Icon.faw_question).setEnabled(false),
//                        new DividerDrawerItem(),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_github).withBadge("12+").withIdentifier(1)
//                        new PrimaryDrawerItem()

                        new PrimaryDrawerItem()
                                .withName(R.string.setting)
                                .withIcon(FontAwesome.Icon.faw_gear)
                                .withIdentifier(1),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem()
                                .withName(R.string.aboutTheProgram)
                                .withIcon(FontAwesome.Icon.faw_info_circle)
                                .withIdentifier(2)
                )

                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {

                        if (drawerItem instanceof Nameable) {
                            switch (drawerItem.getIdentifier()) {
                                case 1:
                                    Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                                    startActivity(intent);
                                    break;
                                case 2:
                                    Toast.makeText(MainActivity.this, R.string.aboutTheProgramToast, Toast.LENGTH_LONG).show();
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
        super.onResume();
        int TimeTextSize = Integer.parseInt(sp.getString("list", "1"));
        if (TimeTextSize != 1) {
            mTextTab1.setTextSize(TimeTextSize);
            mTextTab2.setTextSize(TimeTextSize);

        } else {
            mTextTab1.setTextSize(14);
            mTextTab2.setTextSize(14);
        }

//        MenuItem item_dog = menu.findItem(R.id.navigation_114);

        // делаем его невидимым
//        item_dog.setVisible(false);
//        R.id.navigation_114.
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
