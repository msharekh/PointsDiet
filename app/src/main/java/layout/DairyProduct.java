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
public class DairyProduct extends Fragment {


    public DairyProduct() {
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
        view = inflater.inflate(R.layout.fragment_dairy_product, container, false);
        listView= (ListView) view.findViewById(R.id.listView);

        ElementAdapter adapter=new ElementAdapter(getContext(),generateData());


        listView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Element> generateData(){
        ArrayList<Element> items = new ArrayList<Element>();

        items.add(new Element( 76," المايونيز 1 ملعقة صغيرة ","none", (float)1, 9));
        items.add(new Element( 77," المايونيز لايت 2 ملعقة صغيرة ","none", (float)1, 9));
        items.add(new Element( 78," 30 جرام جبن موزاريلا لايت ","none", (float)1, 9));
        items.add(new Element( 79," 200 جرام من الجبن خالي الدسم ","none", (float)1.5, 9));
        items.add(new Element( 80," زبادو 150 ملل ","none", (float)2, 9));
        items.add(new Element( 81," جبنه فيتا 30 جرام ","none", (float)2, 9));
        items.add(new Element( 82," 30 جرام جبن موزاريلا ","none", (float)2, 9));
        items.add(new Element( 83," 30 جرام الجبن مع القشدة ","none", (float)4, 9));
        return items;
    }

}
