package com.msharekh.com.pd6.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.msharekh.com.pd6.PD;
import com.msharekh.com.pd6.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuotaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuotaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuotaFragment extends Fragment {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;
//
//    public QuotaFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment QuotaFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static QuotaFragment newInstance(String param1, String param2) {
//        QuotaFragment fragment = new QuotaFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle arg = getArguments();
        int id_pass = arg.getInt("ARG_DATA_ID");


        final View view=inflater.inflate(R.layout.fragment_quota, container, false);

        Button buttonCalculateQuota=(Button)view.findViewById(R.id.buttonCalculateQuota);

        buttonCalculateQuota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double currentQuota=getCalculatedQuota(view);

                TextView textViewQoutaPoints= (TextView)view.findViewById(R.id.textViewQoutaPoints);

                textViewQoutaPoints.setText(String.valueOf(currentQuota));

                //Storing data as KEY/VALUE pair in SharedPreferences
                PD.storingInSharedPreferences("key_quota",String.valueOf(currentQuota),getContext());


                PD.d("buttonCalculateQuota pressed = "+String.valueOf(currentQuota));

            }
        });

        // Inflate the layout for this fragment
        return view; }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p/>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

    private double getCalculatedQuota(View v) {
        double quota=0;
        //get values from fields

        RadioButton radioButtonMale;
        RadioButton radioButtonFemale;

        Spinner spinnerAge;
        EditText editTextWeight;
        EditText editTextHight;

        Spinner spinnerActive;

        radioButtonMale= (RadioButton) v.findViewById(R.id.radioButtonMale);
        radioButtonFemale= (RadioButton) v.findViewById(R.id.radioButtonFemale);

        spinnerAge= (Spinner) v.findViewById(R.id.spinnerAge);

        editTextWeight= (EditText) v.findViewById(R.id.editTextWeight);

        editTextHight= (EditText) v.findViewById(R.id.editTextHight);

        spinnerActive= (Spinner) v.findViewById(R.id.spinnerActive);

        //for Gender
        if (radioButtonMale.isChecked()) quota+=15;
        else if(radioButtonFemale.isChecked())quota+=7;

        //for age
        switch (spinnerAge.getSelectedItem().toString()){
            case "12 - 20": quota+=5; break;
            case "21 - 35": quota+=4; break;
            case "36 - 50": quota+=3; break;
            case "51 - 65": quota+=2; break;
        }

        //for weight
        String weight=editTextWeight.getText().toString();
        String digit10=weight.substring(0, 1);
        PD.d("weight= "+weight + " digit= "+digit10);
        quota+=Double.valueOf(digit10);


        //for height
        int hight=Integer.valueOf(editTextHight.getText().toString());
        if(hight<161) quota+=1;
        else quota+=2;

        //for activity

        switch (spinnerActive.getSelectedItem().toString()){
            case "بدون نشاط": quota+=0; break;
            case "غالبا واقف": quota+=1; break;
            case "مجهود عادي": quota+=2; break;
        }

        //save in static method
        //PD.setQuotaLimit(quota);




        return quota;
    }


}
