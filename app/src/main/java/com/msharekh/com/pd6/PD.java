package com.msharekh.com.pd6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by MSH on 07/07/2016.
 */
public class PD {
    public static void d(String txt) {
        Log.d("debugMe", txt);
    }

    public static String getFromSharedPreferences(String key_quota, Context context) {

        //Create SharedPreferences
        SharedPreferences pref = context.getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        String quota = "0";
        try {
            d("pref.getString(key_quota, null)= " + pref.getString(key_quota, null));
            quota = pref.getString(key_quota, null);         // getting String
        } catch (Exception ex) {
            PD.d("No Quota limit..........");

            Toast.makeText(context, "you need to set your Quota lime..", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(context, QuotaActivityX.class);
//            context.startActivity(intent);
        }
        if (quota==null) quota="0";


        return quota;
    }

    public static double totalPoints;

    public static void storingInSharedPreferences(String key_name,String val, Context context) {
        //Storing data as KEY/VALUE pair

        //Create SharedPreferences

        SharedPreferences pref = context.getSharedPreferences("MyPref", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(key_name, val);           // Saving boolean - true/false

        // Save the changes in SharedPreferences
        editor.commit(); // commit changes
    }

    public static void navigateToOtherFragment( FragmentActivity context, Fragment fragment) {
        Bundle args = new Bundle();
        //args.putInt("", id);
        fragment.setArguments(args);

        FragmentTransaction ft = context.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
//                    Intent intent = new Intent(getContext(), DishFragment.class);
//                    getContext().startActivity(intent);


    }


}
