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


public class Meat extends Fragment {

    /*declare variables*/

    ArrayList<Element> elementArrayList;

    private ListView listView;

    private View view;

    public Meat() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //get layout inside fragment
        view = inflater.inflate(R.layout.fragment_meat, container, false);
        listView= (ListView) view.findViewById(R.id.listView);

        ElementAdapter adapter=new ElementAdapter(getContext(),generateData());


        listView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Element> generateData(){
        ArrayList<Element> items = new ArrayList<Element>();

        items.add(new Element(1,  "50 جرام من اللحم البقري واللحوم المدخنة","none", (double)1,1));
        items.add(new Element(2,  "100 جرام من شرائح الدجاج","none", (double)2,1));
        items.add(new Element(3,  "100 جرام من أنواع الكبد","none", (double)3,1));
        items.add(new Element(4,  "حبة كباب","none", (double)3,1));
        items.add(new Element(5,  "ربع دجاجة ( صدر – ورك ) بدون جلد ","none", (double)4,1));
        items.add(new Element(6,  "100 جرام من الدجاج المفروم ","none", (double)4,1));
        items.add(new Element(7,  "قطعة برجر لحم مشوي","none", (double)5,1));
        items.add(new Element(8,  "ربع دجاجة ( صدر – ورك ) بالجلد ","none", (double)5.5,1));
        items.add(new Element(9,  "قطعة مكرونة باشاميل","none", (double)7,1));
        items.add(new Element(10,  "دجاجة كاملة مشوية","none", (double)20,1));


        return items;
    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final ElementAdapter adapter = new ElementAdapter(getContext(), generateData());

        listView = (ListView) view.findViewById(R.id.listView);

        listView.setAdapter(adapter);

    }

    private ArrayList<Element> generateData(){
        ArrayList<Element> items = new ArrayList<Element>();

        items.add(new Element(1,  "50 جرام من اللحم البقري واللحوم المدخنة","none", (float)1,1));
        items.add(new Element(2,  "100 جرام من شرائح الدجاج","none", (float)2,1));
        items.add(new Element(3,  "100 جرام من أنواع الكبد","none", (float)3,1));
        items.add(new Element(4,  "حبة كباب","none", (float)3,1));
        items.add(new Element(5,  "ربع دجاجة ( صدر – ورك ) بدون جلد ","none", (float)4,1));
        items.add(new Element(6,  "100 جرام من الدجاج المفروم ","none", (float)4,1));
        items.add(new Element(7,  "قطعة برجر لحم مشوي","none", (float)5,1));
        items.add(new Element(8,  "ربع دجاجة ( صدر – ورك ) بالجلد ","none", (float)5.5,1));
        items.add(new Element(9,  "قطعة مكرونة باشاميل","none", (float)7,1));
        items.add(new Element(10,  "دجاجة كاملة مشوية","none", (float)20,1));
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
        items.add(new Element(23,  "3 ملاعق أرز بسمتي","none", (float)1,3));
        items.add(new Element(24,  "حساء البصل بأي كمية","none", (float)0,4));
        items.add(new Element(25,  "حساء مع البقدونس بأي كمية","none", (float)0,4));
        items.add(new Element(26,  "حساء الخضار مع الشعيرية 250 ملل","none", (float)0.5,4));
        items.add(new Element(27,  "حساء الخضار مع اللحم 250 ملل","none", (float)2,4));
        items.add(new Element(28,  "حساء البازلاء 250 ملل","none", (float)2,4));
        items.add(new Element(29,  "حساء الطماطم مع اللحم 250 ملل","none", (float)2,4));
        items.add(new Element(30,  "حساء الطماطم مع زلابية والشعيرية 250 ملل","none", (float)2.5,4));
        items.add(new Element(31,  "حساء البازلاء مع السجق 250 ملل","none", (float)5,4));
        items.add(new Element(32,  "البامية أي كمية","none", (float)0,5));
        items.add(new Element(33,  "النعناع أي كمية","none", (float)0,5));
        items.add(new Element(34,  "الفاصوليا الطازجة بأي كمية","none", (float)0,5));
        items.add(new Element(35,  "السبانخ","none", (float)0,5));
        items.add(new Element(36,  "الكرنب","none", (float)0,5));
        items.add(new Element(37,  "الجزر الطازج","none", (float)0,5));


        return items;
    }*/


}
