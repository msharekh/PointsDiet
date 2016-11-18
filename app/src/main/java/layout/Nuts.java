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
public class Nuts extends Fragment {


    public Nuts() {
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
        view = inflater.inflate(R.layout.fragment_nuts, container, false);
        listView= (ListView) view.findViewById(R.id.listView);

        ElementAdapter adapter=new ElementAdapter(getContext(),generateData());


        listView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Element> generateData(){
        ArrayList<Element> items = new ArrayList<Element>();

        items.add(new Element( 58," الزبيب 10 جرام ","none", (float)0.5, 7));
        items.add(new Element( 59," الفستق ( المحمص – المالح ) 10 جرام ","none", (float)1.5, 7));
        items.add(new Element( 60," اللوز 7 قطع ( 10 جرام ) ","none", (float)1.5, 7));
        items.add(new Element( 61," مزيج من المكسرات 10 جرام ","none", (float)1.5, 7));
        items.add(new Element( 62," جوز الهند 15 جرام ","none", (float)2.5, 7));
        items.add(new Element( 63," البندق 7 قطع (7 جرام ) ","none", (float)7, 7));

        return items;
    }

}
