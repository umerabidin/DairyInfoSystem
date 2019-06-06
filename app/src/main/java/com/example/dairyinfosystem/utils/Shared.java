package com.example.dairyinfosystem.activities.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dairyinfosystem.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Shared {

    private static Shared instance = null;

    public synchronized static Shared getInstance() {
        if (instance == null)
            return instance = new Shared();
        return instance;
    }

    public void showDebugLog(String tag, String val) {
        Log.d(tag, val);
    }

    public void showErrorLog(String tag, String val) {
        Log.e(tag, val);
    }

    public void showToastLong(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public void showToastShort(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void showOkDialog(final Activity c, final String msg) {
        Runnable runnable = new Runnable() {
            public void run() {
                if (c != null && !c.isFinishing()) {
                    new AlertDialog.Builder(c).setMessage(msg).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();
                }
            }
        };

        c.runOnUiThread(runnable);

    }

    public void showConfirmDialog(final Activity c, final String msg, final DialogInterface.OnClickListener onClickListener) {
        Runnable runnable = new Runnable() {
            public void run() {
                if (c != null && !c.isFinishing()) {
                    new AlertDialog.Builder(c).setMessage(msg).setTitle("Attention!").setNegativeButton("No", null).setPositiveButton("Yes", onClickListener).setIcon(android.R.drawable.ic_dialog_alert).show();
                }
            }
        };

        c.runOnUiThread(runnable);

    }

    public void showOkDialog(final Activity activity, final String msg, final DialogInterface.OnClickListener onClickListener) {
        Runnable runnable = new Runnable() {
            public void run() {
                if (activity != null && !activity.isFinishing()) {
                    new AlertDialog.Builder(activity).setMessage(msg).setPositiveButton(android.R.string.ok, onClickListener).setIcon(android.R.drawable.ic_dialog_alert).show();
                }
            }
        };
        activity.runOnUiThread(runnable);
    }

    public void callIntentWithFinish(Activity context, Class className, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), context.getPackageName() + ".activities." + className.getSimpleName());
        if (bundle != null) intent.putExtras(bundle);
        context.startActivity(intent);
        context.finish();
    }


    public void callIntent(Activity context, Class className, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), context.getPackageName() + ".activities." + className.getSimpleName());
        if (bundle != null) intent.putExtras(bundle);
        context.startActivity(intent);
    }


    public void callIntentWithResult(Activity context, Class className, int requestCode, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), context.getPackageName() + ".activities." + className.getSimpleName());
        if (bundle != null) intent.putExtras(bundle);
        context.startActivityForResult(intent, requestCode);
    }


    private SimpleDateFormat getDateFormatter() {
        return new SimpleDateFormat("MMMM dd, yyyy");
    }

    public String returnDate(Date mDate) {
        SimpleDateFormat sdf = getDateFormatter();
        Date now;
        if (mDate == null) {
            now = Calendar.getInstance().getTime();
        } else {
            now = mDate;
        }

        return sdf.format(now);
    }

    public void getFormattedDate(Context context, TextView textView, Date mDate) {
        Date dateObj;
        if (mDate == null) {
            dateObj = Calendar.getInstance().getTime();
        } else {
            dateObj = mDate;
        }
       /* String dayNumberSuffix = getDayNumberSuffix(getDay(date));
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d'" + dayNumberSuffix + "', yyyy");
        return dateFormat.format(date);*/

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateObj);
        //2nd of march 2015
        int day = cal.get(Calendar.DATE);

        String date;

        switch (day % 10) {
            case 1:
                date = new SimpleDateFormat("EEEE, MMMM d'st'").format(dateObj);
                break;
            case 2:
                date = new SimpleDateFormat("EEEE, MMMM d'nd'").format(dateObj);
                break;
            case 3:
                date = new SimpleDateFormat("EEEE, MMMM d'rd'").format(dateObj);
                break;
            default:
                date = new SimpleDateFormat("EEEE, MMMM d'th'").format(dateObj);
                break;
        }
        /*SpannableString styledString = new SpannableString(date);

        // superscript
        int startingIndex = date.indexOf(date.substring(date.length() - 8, date.length() - 6));
        int endingIndex = startingIndex + 2;
        styledString.setSpan(new SuperscriptSpan(), startingIndex, endingIndex, 0);
        styledString.setSpan(new RelativeSizeSpan(0.5f), startingIndex, endingIndex, 0);
        styledString.setSpan(new TagSpan(context.getResources().getColor(R.color.transparent), context.getResources().getColor(R.color.blue_color_new)), startingIndex, endingIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        // make it neat
        textView.setGravity(Gravity.CENTER);
        textView.setText(styledString);*/
        textView.setText(date);
    }

    public void getFormattedDate(TextView textView, Date mDate) {
        Date dateObj;
        if (mDate == null) {
            dateObj = Calendar.getInstance().getTime();
        } else {
            dateObj = mDate;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateObj);
        String date = new SimpleDateFormat("MM.dd.yy").format(dateObj);
        textView.setText(date);
    }


    public boolean isWifiConnected(Context mContext) {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            } else return activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
        } else {
            return false;
        }

    }

    public void setFormattedDateWithoutYear(TextView textView, Date mDate) {

        Date dateObj;
        if (mDate == null) {
            dateObj = Calendar.getInstance().getTime();
        } else {
            dateObj = mDate;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateObj);
        int day = cal.get(Calendar.DATE);

        String date;

        switch (day % 10) {
            case 1:
                date = new SimpleDateFormat("EEEE, MMMM d'st'").format(dateObj);
                break;
            case 2:
                date = new SimpleDateFormat("EEEE, MMMM d'nd'").format(dateObj);
                break;
            case 3:
                date = new SimpleDateFormat("EEEE, MMMM d'rd'").format(dateObj);
                break;
            default:
                date = new SimpleDateFormat("EEEE, MMMM d'th'").format(dateObj);
                break;
        }
        textView.setText(date);
    }

    public String getDateInDayMonthYear(Date mDate) {

        Date dateObj;

        if (mDate == null) {
            dateObj = Calendar.getInstance().getTime();
        } else {
            dateObj = mDate;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateObj);
        String date = new SimpleDateFormat("EEEE, MM, dd, yyyy", Locale.US).format(dateObj);
        return date;

    }

    public String getDateMonthYear(Date mDate) {

        Date dateObj;

        if (mDate == null) {
            dateObj = Calendar.getInstance().getTime();
        } else {
            dateObj = mDate;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateObj);
        String date = new SimpleDateFormat("MMMM, yyyy", Locale.US).format(dateObj);
        return date;

    }

    public void callIntentWithFinishAll(Activity context, Class className) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), context.getPackageName() + ".activities." + className.getSimpleName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        context.finish();
    }


    public void customToast(Activity activity, String message) {

        Toast toast = Toast.makeText(activity, message, Toast.LENGTH_LONG);
        View toastView = toast.getView();
        //To change the Background of Toast
//        toastView.setBackgroundColor(Color.TRANSPARENT);
        TextView text = (TextView) toastView.findViewById(android.R.id.message);
        //Shadow of the Of the Text Color
        text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
        text.setTextColor(Color.WHITE);
        text.setGravity(Gravity.CENTER);
        text.setTextSize(activity.getResources().getDimension(R.dimen._4sdp));
        toast.show();


    }
}
