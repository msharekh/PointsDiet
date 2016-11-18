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
public class Fish extends Fragment {



    public Fish() {
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
        view = inflater.inflate(R.layout.fragment_fish, container, false);
        listView= (ListView) view.findViewById(R.id.listView);

        ElementAdapter adapter=new ElementAdapter(getContext(),generateData());


        listView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Element> generateData(){
        ArrayList<Element> items = new ArrayList<Element>();

        items.add(new Element(11,  "السمك النهري 120 جرام ","none", (float)1.5,2));
        items.add(new Element(12,  "الروبيان مقشر 120 جرام ","none", (float)2,2));
        items.add(new Element(13,  "سمك الترس 120 جرام ","none", (float)2,2));
        items.add(new Element(14,  "سمك السلمون المرقط  والمدخن 50 جرام ","none", (float)2,2));
        items.add(new Element(15,  "السلمون المدخن 50 جرام ","none", (float)2,2));
        items.add(new Element(16,  "التونة المعلبة في الملح 100 جرام ","none", (float)2,2));
        items.add(new Element(17,  "الحبار 120 جرام ","none", (float)2,2));
        items.add(new Element(18,  "سمك السلمون 120 جرام الطازج ","none", (float)3.5,2));
        items.add(new Element(19,  "السردين الطازج 120 جرام ","none", (float)3.5,2));
        items.add(new Element(20,  "التونة المعلبة بالزيت 100 جرام ","none", (float)4,2));
        items.add(new Element(21,  "السردين المعلب في صلصة طماطم 100 جرام ","none", (float)4.5,2));
        items.add(new Element(22,  "السردين المعلب بالزيت 100 جرام ","none", (float)4.5,2));
        return items;
    }

}
