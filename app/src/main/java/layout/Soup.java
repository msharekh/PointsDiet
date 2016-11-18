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
public class Soup extends Fragment {


    public Soup() {
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
        view = inflater.inflate(R.layout.fragment_soup, container, false);
        listView= (ListView) view.findViewById(R.id.listView);

        ElementAdapter adapter=new ElementAdapter(getContext(),generateData());


        listView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Element> generateData(){
        ArrayList<Element> items = new ArrayList<Element>();

        items.add(new Element(24,  "حساء البصل بأي كمية","none", (float)0,4));
        items.add(new Element(25,  "حساء مع البقدونس بأي كمية","none", (float)0,4));
        items.add(new Element(26,  "حساء الخضار مع الشعيرية 250 ملل","none", (float)0.5,4));
        items.add(new Element(27,  "حساء الخضار مع اللحم 250 ملل","none", (float)2,4));
        items.add(new Element(28,  "حساء البازلاء 250 ملل","none", (float)2,4));
        items.add(new Element(29,  "حساء الطماطم مع اللحم 250 ملل","none", (float)2,4));
        items.add(new Element(30,  "حساء الطماطم مع زلابية والشعيرية 250 ملل","none", (float)2.5,4));
        items.add(new Element(31,  "حساء البازلاء مع السجق 250 ملل","none", (float)5,4));
        return items;
    }

}
