package classes.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Log;

import com.avos.avoscloud.AVInstallation;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.PushService;
import com.rushucloud.reim.R;
import com.rushucloud.reim.main.MainActivity;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReimApplication extends Application
{
    public static Typeface TypeFaceYaHei;
    public static Typeface TypeFaceAleoLight;

    public static int GUIDE_VERSION = 1;

    private static Context context;

    private static List<Integer> mineUnreadList = new ArrayList<>();
    private static List<Integer> othersUnreadList = new ArrayList<>();
    private static int unreadMessagesCount;
    private static boolean hasUnreadMessages;

    public void onCreate()
    {
        super.onCreate();

        Log.i("&&&",context.toString());
//        initPushService();
//        initMeChat();
        initData();
        createDirectories();
//        saveCategoryIcon();
    }

    public static Context getContext()
    {
        return context;
    }

    private void initPushService()
    {
        AVOSCloud.initialize(this, "25tdcbg3l8kp6yeqa4iqju6g788saf4xlseat1dxma3pdzfc",
                             "yc9e5h624ch14cgavj0r6b5yxq7fmn3y2nlm3hliq763syr1");

        PushService.subscribe(this, "public", MainActivity.class);
        AVInstallation.getCurrentInstallation().saveInBackground();
    }

    private void createDirectories()
    {
        try
        {
            AppPreference appPreference = AppPreference.getAppPreference();
            File dir = new File(appPreference.getAppDirectory());
            if (!dir.exists())
            {
                dir.mkdir();
            }
            dir = new File(appPreference.getAppImageDirectory());
            if (!dir.exists())
            {
                dir.mkdir();
                File nomediaFile = new File(dir, ".nomedia");
                nomediaFile.createNewFile();
            }
            dir = new File(appPreference.getAvatarImageDirectory());
            if (!dir.exists())
            {
                dir.mkdir();
                File nomediaFile = new File(dir, ".nomedia");
                nomediaFile.createNewFile();
                File tempAvatarFile = new File(dir, "temp.jpg");
                tempAvatarFile.createNewFile();
            }
            dir = new File(appPreference.getInvoiceImageDirectory());
            if (!dir.exists())
            {
                dir.mkdir();
                File nomediaFile = new File(dir, ".nomedia");
                nomediaFile.createNewFile();
                File tempInvoiceFile = new File(dir, "temp.jpg");
                tempInvoiceFile.createNewFile();
            }
            dir = new File(appPreference.getIconImageDirectory());
            if (!dir.exists())
            {
                dir.mkdir();
                File nomediaFile = new File(dir, ".nomedia");
                nomediaFile.createNewFile();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void initData()
    {
        context = getApplicationContext();

        TypeFaceYaHei = Typeface.createFromAsset(getAssets(), "fonts/YaHei.ttf");
        TypeFaceAleoLight = Typeface.createFromAsset(getAssets(), "fonts/Aleo_Light.ttf");

        try
        {
            Field field = Typeface.class.getDeclaredField("SERIF");
            field.setAccessible(true);
            field.set(null, TypeFaceYaHei);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

//         ReimProgressDialog.init(context);

        AppPreference.createAppPreference(getApplicationContext());
//        DBManager.createDBManager(getApplicationContext());
//
//        String language = AppPreference.getAppPreference().getLanguage();
//        if (!language.isEmpty())
//        {
//            Locale locale = new Locale(language);
//            Locale.setDefault(locale);
//            Configuration config = getResources().getConfiguration();
//            config.locale = locale;
//            getResources().updateConfiguration(config, getResources().getDisplayMetrics());
//        }

//        DBManager dbManager = DBManager.getDBManager();
//        if (dbManager.isCurrencyTableEmpty())
//        {
//            Currency currency = new Currency("CNY", "¥", 1);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("USD", "$", 622.12);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("EUR", "€", 702.37);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("HKD", "$", 80.24);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("MOP", "$", 80.52);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("TWD", "$", 20.88);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("JPY", "¥", 5.0389);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("KER", "₩", 0.5881);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("GBP", "£", 983.05);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("RUB", "Rbs", 11.56);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("SGD", "$", 465.38);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("PHP", "₱", 14.23);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("IDR", "Rps", 0.0482);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("MYR", "$", 165.96);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("THB", "฿", 19.06);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("CAD", "$", 505.07);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("AUD", "$", 480.12);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("NZD", "$", 429.4);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("CHF", "₣", 672.45);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("DKK", "Kr", 94.17);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("NOK", "Kr", 80.1);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("SEK", "Kr", 76.1);
//            dbManager.insertCurrency(currency);
//
//            currency = new Currency("BRL", "$", 210.98);
//            dbManager.insertCurrency(currency);
//        }
    }

}