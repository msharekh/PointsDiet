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
public class Candy extends Fragment {


    public Candy() {
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
        view = inflater.inflate(R.layout.fragment_candy, container, false);
        listView= (ListView) view.findViewById(R.id.listView);

        ElementAdapter adapter=new ElementAdapter(getContext(),generateData());


        listView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Element> generateData(){
        ArrayList<Element> items = new ArrayList<Element>();

        items.add(new Element( 84," فطيرة الفواكة 100 جرام ","none", (float)1.5, 10));
        items.add(new Element( 85," البقلاوة 30 جرام ","none", (float)3, 10));
        items.add(new Element( 86," قطعة كعكة الشوكولاته 35 جرام ","none", (float)3.5, 10));
        items.add(new Element( 87," حبة كرواسون الأنواع الأخري 50 جرام ","none", (float)4, 10));
        items.add(new Element( 88," حبة كرواسون اللوز 50 جرام ","none", (float)5, 10));
        items.add(new Element( 89," حبة دونات 60 جرام ","none", (float)5.5, 10));
        items.add(new Element( 90," حبة كرواسون الشوكولاته 60 جرام ","none", (float)5.5, 10));
        items.add(new Element( 91," الكعكة 50 جرام ","none", (float)5.5, 10));
        items.add(new Element( 92," مكعب تشيز كيك ","none", (float)8, 10));
        return items;
    }

}
