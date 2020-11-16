package uk.lgl.modmenu;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.Settings;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;

public class StaticActivity {
    public static String cacheDir;
    @SuppressLint("StaticFieldLeak")
    private static HashMap<String, Object> hashmap = new HashMap<>();
    private static Intent intent = new Intent();

    @SuppressLint("SetTextI18n")
    public static void Start(final Context context) {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //Create LinearLayout
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        android.graphics.drawable.GradientDrawable DCCEECCx = new android.graphics.drawable.GradientDrawable();
        DCCEECCx.setColor(Color.parseColor("#ff00ff00"));
        DCCEECCx.setCornerRadius(10);
        DCCEECCx.setStroke(1, Color.parseColor("#FF000000"));
        linearLayout.setBackground(DCCEECCx);
        //Create button
        Button button = new Button(context);
        LinearLayout.LayoutParams layoutParamss = new LinearLayout.LayoutParams(-1, 70);
        layoutParamss.setMargins(20, 50, 20, 25);
        button.setLayoutParams(layoutParamss);
        android.graphics.drawable.GradientDrawable DCCEECC1 = new android.graphics.drawable.GradientDrawable();
        DCCEECC1.setColor(Color.parseColor("#ffff0000"));
        DCCEECC1.setCornerRadius(10);
        DCCEECC1.setStroke(1, Color.parseColor("#FFFFFF"));
        button.setBackground(DCCEECC1);
        button.setShadowLayer(18.0f, 0.0f, 0.0f, Color.parseColor("#FFFF00"));
        button.setText("Login");
        //Create button
        Button button2 = new Button(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 70);
        layoutParams.setMargins(20, 25, 20, 50);
        button2.setLayoutParams(layoutParams);
        button2.setTextSize(12.0f);
        button2.setTextColor(Color.parseColor("#FFFFFF"));
        android.graphics.drawable.GradientDrawable DCCEECC = new android.graphics.drawable.GradientDrawable();
        DCCEECC.setColor(Color.parseColor("#1565c0"));
        DCCEECC.setCornerRadius(10);
        DCCEECC.setStroke(1, Color.parseColor("#FF000000"));
        button2.setBackground(DCCEECC);
        button2.setShadowLayer(18.0f, 0.0f, 0.0f, Color.parseColor("#00000000"));
        button2.setText(Html.fromHtml("<font color=#00ccff><a href=https://t.me/xxxx><u>Join Official Telegram</font>"));
        button2.setMovementMethod(LinkMovementMethod.getInstance());
        linearLayout.addView(button);
        linearLayout.addView(button2);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setView(linearLayout);
        final AlertDialog alertDialog = builder.show();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                cacheDir = context.getCacheDir().getPath() + "/";
                alertDialog.dismiss();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(context)) {
                    AlertDialog alertDialog = new AlertDialog.Builder(context, 1)
                            .setTitle("No overlay permission")
                            .setMessage("Overlay permission is required in order to display the mod menu on top of the screen. Do you want to open the settings?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    context.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION",
                                            Uri.parse("package:" + context.getPackageName())));
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    intent.setAction(Intent.ACTION_VIEW);
                                    intent.setData(Uri.parse("http://t.me/xxxx"));
                                    context.startActivity(intent);
                                }
                            })
                            .setCancelable(false)
                            .create();
                    alertDialog.show();
                }
                //Change your raw paste to something to make it go expired
                if (callURL("https://pastebin.com/raw/dKssHPy3").equals("day78")) {
                    //Toast toast = Toast.makeText(context.getApplicationContext(), "Loading mod menu", Toast.LENGTH_SHORT);toast.show();
                    System.loadLibrary("s");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            context.startService(new Intent(context, loader.class));
                        }
                    }, 1);
                } else {
                    Toast toast = Toast.makeText(context.getApplicationContext(), "Expired", Toast.LENGTH_SHORT);
                    toast.show();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://t.me/xxxx"));
                    context.startActivity(intent);
                }

            }
        });
    }

    public static String callURL(String myURL) {
        System.out.println("Requeted URL:" + myURL);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:" + myURL, e);
        }
        Log.d("gettextfromurl", sb.toString());
        return sb.toString();
    }
}
