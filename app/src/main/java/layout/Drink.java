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
public class Drink extends Fragment {


    public Drink() {
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
        view = inflater.inflate(R.layout.fragment_drink, container, false);
        listView= (ListView) view.findViewById(R.id.listView);

        ElementAdapter adapter=new ElementAdapter(getContext(),generateData());


        listView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Element> generateData(){
        ArrayList<Element> items = new ArrayList<Element>();

        items.add(new Element( 64," مسحوق الكاكاو ( بدون سكر) 1 ملعقة0 والملعقة الثانية 1 نقطة","none", (float)0, 8));
        items.add(new Element( 65," الشاي بجميع أنواعه بأي كمية ","none", (float)0, 8));
        items.add(new Element( 66," عصير الليمون ","none", (float)0, 8));
        items.add(new Element( 67," عصير الطماطم 250 ملل ","none", (float)0.5, 8));
        items.add(new Element( 68," كابتشينو 100 ملل ","none", (float)1, 8));
        items.add(new Element( 69," عصير البرتقال الغير محلى 200 ملل ","none", (float)1, 8));
        items.add(new Element( 70," عصير العنب الغير محلى 200 ملل ","none", (float)1, 8));
        items.add(new Element( 71," عصير الفواكه الغير محلى 200 ملل ","none", (float)1, 8));
        items.add(new Element( 72," عصير الجزر 250 ملل ","none", (float)1, 8));
        items.add(new Element( 73," عصير الأناناس غير محلى 200 ملل ","none", (float)1, 8));
        items.add(new Element( 74," علبة الشاي المثلج 330 ملل ","none", (float)2.5, 8));
        items.add(new Element( 75," البيبسي ","none", (float)3, 8));
        return items;
    }

}
