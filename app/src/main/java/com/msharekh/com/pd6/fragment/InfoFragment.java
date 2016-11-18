package com.msharekh.com.pd6.fragment;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.msharekh.com.pd6.PD;
import com.msharekh.com.pd6.R;
import com.msharekh.com.pd6.donatgraph.PieGraph;
import com.msharekh.com.pd6.donatgraph.PieSlice;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    PieGraph pg;
    PieSlice ps1, ps2, ps3;

    int item_1, item_2, item_3;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showUserInfo();


    }

    private void showUserInfo() {
        //From PD5

        double quota = Double.valueOf(PD.getFromSharedPreferences("key_quota", getActivity()));

        double points = PD.totalPoints;

        double remainingPoints = quota - points;


        //        //show quota info
//        TextView textViewQuota= (TextView) findViewById(R.id.textViewQuota);
//        textViewQuota.setText(getResources().getString(R.string.you_have_quota)+" : "+String.valueOf(quota));
//
//        //calculate remaining
//
//
        //show remaining info
        TextView textViewRemaining= (TextView) getView().findViewById(R.id.textViewRemaining);
        String strRemain=String.valueOf(remainingPoints)+"  "+getResources().getString(R.string.you_have_remaining);
        textViewRemaining.setText(strRemain);



        //Draw Donat Graph

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        pg = (PieGraph) getView().findViewById(R.id.pie);

        item_1 = (int)(quota + 0.5d);
        item_2 = (int)(remainingPoints + 0.5d);
//        item_3 = 33;
//        ps1 = new PieSlice();
//        ps1.setColor(Color.RED);
//        ps1.setValue(item_1);
//
//        ps2 = new PieSlice();
//        ps2.setColor(Color.GREEN);
//        ps2.setValue(item_2);
//
//        ps3 = new PieSlice();
//        ps3.setColor(Color.CYAN);
//        ps3.setValue(item_3);

//        pg.addSlice(ps1);
//        pg.addSlice(ps2);
//        pg.addSlice(ps3);

        ps1 = new PieSlice();
        ps1.setColor(getResources().getColor(R.color.colorPizzWhite));
        ps1.setValue(item_1);

        ps2 = new PieSlice();
        ps2.setColor(getResources().getColor(R.color.colorPizzBlue));
        ps2.setValue(item_2);

        pg.addSlice(ps1);
        pg.addSlice(ps2);


        pg.setInnerCircleRatio(220);



    }
}
