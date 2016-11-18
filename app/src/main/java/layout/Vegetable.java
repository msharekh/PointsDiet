package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.msharekh.com.pd6.model.Element;
import com.msharekh.com.pd6.adapter.ElementAdapter;
import com.msharekh.com.pd6.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Vegetable extends Fragment {


    public Vegetable() {
        // Required empty public constructor
    }

    /*declare variables*/

    ArrayList<Element> elementArrayList;

    private ListView listView;

    private View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //get layout inside fragment
        view = inflater.inflate(R.layout.fragment_vegetable, container, false);
        listView= (ListView) view.findViewById(R.id.listView);

        ElementAdapter adapter=new ElementAdapter(getContext(),generateData());


        listView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Element> generateData(){
        ArrayList<Element> items = new ArrayList<Element>();

        items.add(new Element(32,  "البامية أي كمية","none", (float)0,5));
        items.add(new Element(33,  "النعناع أي كمية","none", (float)0,5));
        items.add(new Element(34,  "الفاصوليا الطازجة بأي كمية","none", (float)0,5));
        items.add(new Element(35,  "السبانخ","none", (float)0,5));
        items.add(new Element(36,  "الكرنب","none", (float)0,5));
        items.add(new Element(37,  "الجزر الطازج","none", (float)0,5));
        return items;
    }

}
