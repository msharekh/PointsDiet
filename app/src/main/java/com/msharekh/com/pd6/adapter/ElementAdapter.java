package com.msharekh.com.pd6.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.msharekh.com.pd6.model.DishElement;
import com.msharekh.com.pd6.PD;
import com.msharekh.com.pd6.R;
import com.msharekh.com.pd6.fragment.DishFragment;
import com.msharekh.com.pd6.model.Element;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by MSH on 25/06/2016.
 */
public class ElementAdapter extends ArrayAdapter<Element> {
    Context context;
    ArrayList<Element> elementArrayList = null;

    public ElementAdapter(Context context, ArrayList<Element> elementArrayList) {
        super(context, R.layout.element_row, elementArrayList);
        this.context = context;

        this.elementArrayList = elementArrayList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.element_row, parent, false);


        // 3. Get the  views from the rowView
        final LinearLayout linearLayoutSelectElement = (LinearLayout) rowView.findViewById(R.id.linearLayoutSelectElement);
        //final Button linearLayoutSelectElement = (Button) rowView.findViewById(R.id.linearLayoutSelectElement);

        Button buttonAdd = (Button) rowView.findViewById(R.id.buttonAdd);
        Button buttonRemove = (Button) rowView.findViewById(R.id.buttonRemove);

        TextView textViewElementName = (TextView) rowView.findViewById(R.id.textViewElementName);
        TextView textViewElementDesc = (TextView) rowView.findViewById(R.id.textViewElementDesc);

        final TextView textViewElementPoints = (TextView) rowView.findViewById(R.id.textViewElementPoints);

        // 4. Set the text for Views
        textViewElementName.setText(elementArrayList.get(position).getName());
        textViewElementDesc.setText(elementArrayList.get(position).getDesc());

        final double currentPoint = elementArrayList.get(position).getPoints();
        textViewElementPoints.setText(String.valueOf(currentPoint));

        // selecting element and adding to dish
        linearLayoutSelectElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double newPoint = Double.valueOf(textViewElementPoints.getText().toString());
                addToDish(elementArrayList.get(position).getId(), elementArrayList.get(position).getName(), elementArrayList.get(position).getDesc(), newPoint,context);

            }
        });


        //adding quantity
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double newPoint = Double.valueOf(textViewElementPoints.getText().toString());
                newPoint += (currentPoint * 0.5);
                if (newPoint >= 0) {
                    textViewElementPoints.setText(String.valueOf(newPoint));
                }
            }
        });

        //removing quantity
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double newPoint = Double.valueOf(textViewElementPoints.getText().toString());
                newPoint -= (currentPoint * 0.5);
                if (newPoint >= 0) {
                    textViewElementPoints.setText(String.valueOf(newPoint));
                }
            }
        });

      /*  buttonElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "From Adapter", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(),DishActivity.class);
                getContext().startActivity(intent);
            }
        });
*/

        // 5. retrn rowView
        return rowView;
    }

    private double getDishElementsTotalPoints() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<DishElement> query = realm.where(DishElement.class);

        // Execute the query:
        RealmResults<DishElement> result1 = query.findAll();

        // Defined Array values to show in ListView
        double totalPoints = 0;

        for (int i = 0; i < result1.size(); i++) {
            totalPoints += result1.get(i).getPoints();
        }


        return totalPoints;
    }

    private void addToDish(int id, String name, String desc, double points, Context context) {

        //check if you accede the quota limit
        double currentQuota = getDishElementsTotalPoints();
        PD.d("currentQuota= "+currentQuota);
        try
        {
            double quotaLimit =Double.valueOf(PD.getFromSharedPreferences("key_quota",this.context)) ;
            PD.d("quotaLimit= "+quotaLimit);

            if (currentQuota+points>quotaLimit) {
                PD.d("you accede limit..........");
                Toast.makeText(this.context, "you accede limit?? Try delete items from dish", Toast.LENGTH_SHORT).show();
            }
            else
            {

                PD.d("you Not accede limit..........");
                try {
                    SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
                    Date todayDate = new Date();
                    String thisDate = currentDate.format(todayDate);

                    createRecordInRelam(id, name, desc, points,todayDate);

                    //moving to other fragment
                    Fragment fragment = null;
                    fragment = new DishFragment();

                    PD.navigateToOtherFragment((FragmentActivity) context, fragment);
                    Toast.makeText(getContext(), "Dish element added..", Toast.LENGTH_SHORT).show();

                } catch (Exception ex) {

                    Toast.makeText(getContext(), "Noooo added..", Toast.LENGTH_SHORT).show();

                }

            }
        }
        catch (Exception ex){
            PD.d("No Quta limit..........");
//            Intent intent = new Intent(getContext(), QuotaActivityX.class);
//            getContext().startActivity(intent);
            Toast.makeText(this.context, "you need to set your Quota lime..", Toast.LENGTH_LONG).show();


        }



    }



    private void createRecordInRelam(int id, String name, String desc, double points, Date todayDate) {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        //... add or update objects here ...

        DishElement dishElement = realm.createObject(DishElement.class);

        dishElement.setElementId(id);
        dishElement.setName(name);
        dishElement.setDishDate(todayDate);
        dishElement.setDesc(desc);
        dishElement.setPoints(points);

        //DishElement realmdishElement = realm.copyToRealm(dishElement);
        realm.commitTransaction();
    }





    /*@Override
    public Filter getFilter() {
        return super.getFilter();

    }*/

   /* private class ValueFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<Element> filterList = new ArrayList<Element>();
                for (int i = 0; i < elementArrayList.size(); i++) {
                    if ( (elementArrayList.get(i).getName() ).contains(constraint.toString())) {

                        Element element = new Element(
                                elementArrayList.get(i).getId(),
                                elementArrayList.get(i).getName(),
                                elementArrayList.get(i).getName(),
                                elementArrayList.get(i).getPoints(),
                                elementArrayList.get(i).getCategoryId());

                        filterList.add(element);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = elementArrayList.size();
                results.values = elementArrayList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {


// Now we have to inform the adapter about the new list filtered
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                elementArrayList = (ArrayList<Element>) results.values;
                notifyDataSetChanged();
            }
        }
    }*/
}

