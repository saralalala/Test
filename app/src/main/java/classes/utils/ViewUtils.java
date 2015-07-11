package classes.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Toast;

public class ViewUtils
{
    public static int dpToPixel(double dp)
    {
        DisplayMetrics metrics = ReimApplication.getContext().getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) dp, metrics);
    }

    public static int getColor(int colorResID)
    {
        return ReimApplication.getContext().getResources().getColor(colorResID);
    }

    public static String getString(int stringResID)
    {
        return ReimApplication.getContext().getResources().getString(stringResID);
    }

    public static void showToast(Context context, String content)
    {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, int resID)
    {
        Toast.makeText(context, resID, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, int resID, String errorMessage)
    {
        Toast.makeText(context, context.getString(resID) + "，" + errorMessage, Toast.LENGTH_SHORT).show();
    }
}