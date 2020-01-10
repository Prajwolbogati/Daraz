package com.example.daraz.strictmode;

public class Strictmodeclass {
    public static void Strictmode() {
        android.os.StrictMode.ThreadPolicy policy =
                new android.os.StrictMode.ThreadPolicy.Builder()
                        .permitAll().build();

        android.os.StrictMode.setThreadPolicy(policy);
    }
}
