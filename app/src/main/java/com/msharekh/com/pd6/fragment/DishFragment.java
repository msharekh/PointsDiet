package com.msharekh.com.pd6.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.msharekh.com.pd6.model.DishElement;
import com.msharekh.com.pd6.PD;
import com.msharekh.com.pd6.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class DishFragment extends Fragment {


    public DishFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_dish, container, false);

        //showDishElements();

        showDishElementsWithCustomAdapter(view);

        calculateTotalPoints(view);


        showDishDate(view);

        //go to list to add new element
        Button buttonAddElement= (Button) view.findViewById(R.id.buttonAddElement);
        buttonAddElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //moving to other fragment
                Fragment fragment = null;
                fragment = new ListFragment();

                PD.navigateToOtherFragment( getActivity(), fragment);

//                Intent intent = new Intent(getContext(), android.app.ListActivity.class);
//                startActivity(intent);
            }
        });
        return view;
    }

    private void showDishDate(View view) {
        TextView textViewDishDate = (TextView) view.findViewById(R.id.textViewDishDate);

        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        textViewDishDate.setText(thisDate);
    }

    private void calculateTotalPoints(View view) {

        //Calculate number of element in dish

        double totalPoints = 0;

        PD.d(String.valueOf(totalPoints));
        // Get ListView object from xml
        ListView listView = (ListView) view.findViewById(R.id.listViewDish);
        for (int i = 0; i < listView.getCount(); i++) {

            View v = listView.getAdapter().getView(i, null, null);
            TextView textViewPoints = (TextView) v.findViewById(R.id.textViewPoints);
            //PD.d("textViewPoints = " + String.valueOf(textViewPoints.getText().toString()));

            totalPoints += Double.valueOf(textViewPoints.getText().toString());



            /** you can try to log your values EditText */
            //d( String.valueOf("points = "+totalPoints));

        }

        PD.totalPoints=totalPoints;
        PD.d( String.valueOf("points in PD = "+PD.totalPoints));

        TextView textViewTotalPoints = (TextView) view.findViewById(R.id.textViewTotalPoints);
        textViewTotalPoints.setText(String.valueOf(totalPoints));







        TextView textViewQuotaLimit = (TextView) view.findViewById(R.id.textViewQuotaLimit);



        // d("QuotaLimit= "+String.valueOf(PD.getQuotaLimit()));
        // textViewQuotaLimit.setText(String.valueOf(PD.getQuotaLimit()));

        PD.d("getFromSharedPreferences( key_quota )= " + PD.getFromSharedPreferences("key_quota", getContext()));
        textViewQuotaLimit.setText(PD.getFromSharedPreferences("key_quota", getContext()));

        //d(totalPoints.toString());
    }



    private void showDishElementsWithCustomAdapter(View view) {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<DishElement> query = realm.where(DishElement.class);

        // Execute the query:
        RealmResults<DishElement> result1 = query.findAll();


        // Get ListView object from xml
        ListView listView = (ListView) view.findViewById(R.id.listViewDish);

        // Defined Array values to show in ListView
        ArrayList<DishElement> dishElementArrayList = new ArrayList<DishElement>();

        for (int i = 0; i < result1.size(); i++) {
            dishElementArrayList.add(result1.get(i));
        }

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data


        // Create the Adapter

        final DishElementAdapter dishElementAdapter = new DishElementAdapter(getContext(), dishElementArrayList);


        // Assign adapter to ListView
        listView.setAdapter(dishElementAdapter);


    }


//    private void showDishElements() {
//
//        Realm realm = Realm.getDefaultInstance();
//        RealmQuery<DishElement> query = realm.where(DishElement.class);
//
//        // Execute the query:
//        RealmResults<DishElement> result1 = query.findAll();
//
//
//        // Get ListView object from xml
//        ListView listView = (ListView) view.findViewById(R.id.listViewDish);
//
//        // Defined Array values to show in ListView
//        String[] values = new String[result1.size()];
//        for (int i = 0; i < result1.size(); i++) {
//            values[i] = String.valueOf(result1.get(i).getElementId()) + " | " + result1.get(i).getName().toString() + " | " + String.valueOf(result1.get(i).getPoints());
//        }
//
//        // Define a new Adapter
//        // First parameter - Context
//        // Second parameter - Layout for the row
//        // Third parameter - ID of the TextView to which the data is written
//        // Forth - the Array of data
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
//                android.R.layout.simple_list_item_1, values);
//
//
//        // Assign adapter to ListView
//        listView.setAdapter(adapter);
//
//
//    }

    private void removeSingleObject(int elementId) {

        // Build the query:
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<DishElement> deleteQuery = realm.where(DishElement.class);

        // Add query conditions:
        deleteQuery.equalTo("elementId", elementId);
        //query.or().equalTo("name", "Peter");

        // Execute the query:
        RealmResults<DishElement> deleteResult = deleteQuery.findAll();
        // All changes to data must happen in a transaction
        realm.beginTransaction();

        // remove single match
        deleteResult.remove(0);
        deleteResult.removeLast();

        // Delete all matches
        deleteResult.clear();

        realm.commitTransaction();


    }

    private class DishElementAdapter extends ArrayAdapter<DishElement> {

        Context context;
        ArrayList<DishElement> dishElementArrayList = null;

        public DishElementAdapter(Context context, ArrayList<DishElement> dishElementArrayList) {
            super(context, R.layout.dish_element_row, dishElementArrayList);
            this.context = context;

            this.dishElementArrayList = dishElementArrayList;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            //d("get View");
            //LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            // 1. Create inflater
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 2. Get rowView from inflater
            final View rowView = inflater.inflate(R.layout.dish_element_row, parent, false);


            TextView textViewName = (TextView) rowView.findViewById(R.id.textViewName);
            textViewName.setText(dishElementArrayList.get(position).getName().toString());
            TextView textViewElementId = (TextView) rowView.findViewById(R.id.textViewElementId);
            textViewElementId.setText(String.valueOf(dishElementArrayList.get(position).getElementId()));
            TextView textViewPoints = (TextView) rowView.findViewById(R.id.textViewPoints);
            textViewPoints.setText(String.valueOf(dishElementArrayList.get(position).getPoints()));


            Button deleteButton = (Button) rowView.findViewById(R.id.deleteButton);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PD.d("I am Clicked");
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getContext());
                    // Add the buttons
                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK button
                            PD.d("accept");

                            try {
                                removeSingleObject(dishElementArrayList.get(position).getElementId());
                                PD.d("deleted");
                                showDishElementsWithCustomAdapter(rowView);
                                calculateTotalPoints(rowView);
                                Toast.makeText(getContext(), "deleted", Toast.LENGTH_SHORT).show();
                            } catch (Exception ex) {
                                Toast.makeText(getContext(), "....Not!", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                            PD.d("canceled");
                        }
                    });
                    // Set other dialog properties
                    builder.setTitle(getResources().getString(R.string.DeleteDialogTitle));
                    builder.setMessage(getResources().getString(R.string.DeleteDialogMessage));

// Create the AlertDialog
                    android.support.v7.app.AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });


            return rowView;
        }

        @Override
        public int getCount() {
            return super.getCount();

        }
    }

}
