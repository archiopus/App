package com.example.app1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "myLogs";
    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;
    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;
    TextView TV1, TV2, TV3;
    //**********************************************************************************************
    final View.OnClickListener clickBtn = new View.OnClickListener() {
        //        @SuppressLint("SetTextI18n")
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View vv) {
            switch (vv.getId()) {
                case R.id.But1:
                    TV1.setText(R.string.T1);
                    Log.d(TAG, "Выбор 1");
                    break;
                case R.id.But2:
                    TV1.setText(R.string.T2);
                    Log.d(TAG, "Выбор 2");
                    break;
                case R.id.But3:
                    TV1.setText(R.string.T3);
                    Log.d(TAG, "Выбор 3");
                    break;
                case R.id.Text3:
                    TV1.setText(R.string.T4);

                    Log.d(TAG, "Выбор 4");
//                    Toast.makeText(this, "Нажата кнопка ОК", Toast.LENGTH_LONG).show();
                    break;
                default:
                    TV1.setText("0");
            }
        }
    };
    Button BT1, BT2, BT3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

/*
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams linLayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(linearLayout, linLayoutParams);
*/


        TV1 = (TextView) findViewById(R.id.Text1);
        TV2 = (TextView) findViewById(R.id.Text2);
        TV3 = (TextView) findViewById(R.id.Text3);
        BT1 = (Button) findViewById(R.id.But1);
        BT2 = (Button) findViewById(R.id.But2);
        BT3 = (Button) findViewById(R.id.But3);
//        BT1.setOnClickListener(clickBtn);
        BT1.setOnClickListener(this);
        BT2.setOnClickListener(clickBtn);
        BT3.setOnClickListener(clickBtn);
        TV3.setOnClickListener(clickBtn);

        registerForContextMenu(TV1);
        registerForContextMenu(TV2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(0, 1, 0, "menu1");
        menu.add(0, 2, 0, "menu2");
        menu.add(1, 3, 0, "menu3");
        menu.add(1, 4, 0, "menu4");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(0, true);
        menu.setGroupVisible(1, false);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();

        switch (item.getItemId()) {
            case 1:
                TV2.setText("1");
                Log.d(TAG, "Меню 1");
                break;
            case 2:
                TV2.setText("2");
                Log.d(TAG, "Меню 2");
                break;
            case 3:
                TV2.setText("3");
                Log.d(TAG, "Меню 3");
                break;
            default:
                TV2.setText("0");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()) {
            case R.id.Text1:
                menu.add(0, MENU_COLOR_RED, 0, "Red");
                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
                break;
            case R.id.Text2:
                menu.add(0, MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_COLOR_RED:
                TV1.setTextColor(Color.RED);
                TV1.setText(R.string.R1);
                break;
            case MENU_COLOR_GREEN:
                TV1.setTextColor(Color.GREEN);
                TV1.setText(R.string.R2);
                break;
            case MENU_COLOR_BLUE:
                TV1.setTextColor(Color.BLUE);
                TV1.setText(R.string.R3);
                break;
            case MENU_SIZE_22:
                TV2.setTextSize(22);
                TV2.setText(R.string.R4);
                break;
            case MENU_SIZE_26:
                TV2.setTextSize(26);
                TV2.setText(R.string.R5);
                break;
            case MENU_SIZE_30:
                TV2.setTextSize(30);
                TV2.setText(R.string.R6);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        TV1.setText(R.string.R0);
        Log.d(TAG, "Меню 001");

    }


}