package es.source.code.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainScreen extends AppCompatActivity {
    BottomNavigationBar naviBar;
    private boolean orderHide = true;
    private boolean initialized = false;
    String from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Log.v("create", "create");
        initialized = false;
        orderHide = true;
        Intent intent = getIntent();
        try {
            from = intent.getStringExtra("From");
            intent = null;
        } catch (Exception except) {
            // TODO: 2018/9/19
        }
        //Log.v("Activity From", from);
        //navi Bar
        naviBar = findViewById(R.id.naviBar_Main);
        naviBar
                .setTabSelectedListener(new mySelect())
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .setInActiveColor("#DDDDDD")
                .setBarBackgroundColor("#FFFFFF")
                .setActiveColor(R.color.colorAccent);
        if (orderHide) {
            if (from.equals("FromEntry") || from.equals("LoginSuccess")) {
                Log.v("add", "in");
                naviBar.addItem(new BottomNavigationItem(R.drawable.ic_add_shopping_cart_white_48dp, "查看订单"))
                        .addItem(new BottomNavigationItem(R.drawable.ic_restaurant_menu_white_48dp, "点菜"));
                orderHide = false;
            }
        }
        if (!initialized) {
            naviBar.addItem(new BottomNavigationItem(R.drawable.ic_perm_identity_white_48dp, "登陆/注册"))
                    .addItem(new BottomNavigationItem(R.drawable.ic_help_outline_white_48dp, "系统帮助"));
            initialized = true;
        }
        naviBar.initialise();
        //set default Fragment
        //To Do
    }

    @Override
    protected void onStart() {
        Log.v("start", "start");
        super.onStart();
    }

    private class mySelect implements BottomNavigationBar.OnTabSelectedListener {
        @Override
        public void onTabSelected(int position) {
            if (orderHide) {
                //need to be improved
                switch (position) {
                    case 0:// select login
                        Intent intent = new Intent(MainScreen.this, LoginOrRegister.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                        break;
                    case 1://select help
                        break;
                    default:
                        break;
                }
            } else {
                switch (position) {
                    case 0: //command
                        break;
                    case 1://order
                        break;
                    case 2: //login
                        Intent intent = new Intent(MainScreen.this, LoginOrRegister.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                        break;
                    case 3://help
                        break;
                    default:
                        break;
                }
            }
        }

        @Override
        public void onTabUnselected(int position) {

        }

        @Override
        public void onTabReselected(int position) {
            if (orderHide) {
                switch (position) {
                    case 0:
                        //need to be improved
                        Intent intent = new Intent(MainScreen.this, LoginOrRegister.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                        break;
                    case 1://help
                        break;
                    default:
                        break;
                }
            } else {
                switch (position) {
                    case 0: //command
                        break;
                    case 1://order
                        break;
                    case 2: //login
                        Intent intent = new Intent(MainScreen.this, LoginOrRegister.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                        break;
                    case 3://help
                        break;
                    default:
                        break;
                }
            }
        }
    }
}

