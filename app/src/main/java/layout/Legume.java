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
public class Legume extends Fragment {


    public Legume() {
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
        view = inflater.inflate(R.layout.fragment_legume, container, false);
        listView= (ListView) view.findViewById(R.id.listView);

        ElementAdapter adapter=new ElementAdapter(getContext(),generateData());


        listView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Element> generateData(){
        ArrayList<Element> items = new ArrayList<Element>();

        items.add(new Element( 47," مردقوش ","none", (float)0, 6));
        items.add(new Element( 48," الشمر ","none", (float)0, 6));
        items.add(new Element( 49," الخردل ","none", (float)0, 6));
        items.add(new Element( 50," التوابل بجميع أنواعها ","none", (float)0, 6));
        items.add(new Element( 51," القرفة ","none", (float)0, 6));
        items.add(new Element( 52," كمون ","none", (float)0, 6));
        items.add(new Element( 53," الفول المجفف الخام 30 جرام ","none", (float)1.5, 6));
        items.add(new Element( 54," الحمص 100 جرام ","none", (float)2, 6));
        items.add(new Element( 55," العدس الجاف 30 جرام ","none", (float)2, 6));
        items.add(new Element( 56," العدس المطبوخ 120 جرام ","none", (float)2, 6));
        items.add(new Element( 57," الفاصوليا البيضاء (المطبوخة) 120 جرام ","none", (float)2, 6));
        return items;
    }

}
