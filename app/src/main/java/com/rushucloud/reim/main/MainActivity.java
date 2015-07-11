package com.rushucloud.reim.main;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

import com.rushucloud.reim.R;

import classes.utils.ViewUtils;

public class MainActivity extends FragmentActivity
{

    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if (System.currentTimeMillis() - exitTime > 2000)
            {
                ViewUtils.showToast(MainActivity.this, R.string.prompt_press_back_to_exit);
                exitTime = System.currentTimeMillis();
            }
            else
            {
                finish();
//                dbManager.closeDatabase();
//                if (webSocketClient != null && !webSocketIsClosed)
//                {
//                    webSocketClient.close();
//                }
                android.os.Process.killProcess(android.os.Process.myPid());
            }
            return true;
        }
        else
        {
            return super.onKeyDown(keyCode, event);
        }
    }

}
