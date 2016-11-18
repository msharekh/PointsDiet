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
public class OtherX extends Fragment {


    public OtherX() {
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
        view = inflater.inflate(R.layout.fragment_other_x, container, false);
        listView= (ListView) view.findViewById(R.id.listView);

        ElementAdapter adapter=new ElementAdapter(getContext(),generateData());


        listView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Element> generateData(){
        ArrayList<Element> items = new ArrayList<Element>();

        items.add(new Element( 93," كوب فشار ","none", (float)3, 11));
        items.add(new Element( 94," شيبسي صغير الحجم ","none", (float)3, 11));
        items.add(new Element( 95," كيس واحد أندومي ","none", (float)6, 11));


        //new from info file

        items.add(new Element( 96, " عصير الخضار والطماطم   ","none", (float)0, 11));
        items.add(new Element( 97, " الكوسا والخس والجزر والخيار وجميع أنواع الخضار ","none", (float)0, 11));
        items.add(new Element( 98, " كل مشروبات الدايت ","none", (float)0, 11));
        items.add(new Element( 99, " برتقالة او إجاصة","none", (float)0, 11));
        items.add(new Element( 100, " تفاح ","none", (float)0, 11));
        items.add(new Element( 101, " برتقال ","none", (float)0, 11));
        items.add(new Element( 102, " الكوسا والخس والجزر والخيار وجميع أنواع الخضار","none", (float)0, 11));
        items.add(new Element( 103, " الملوخية  بدون اي اضافات ","none", (float)0, 11));
        items.add(new Element( 104, " حساء الدجاج أو اللحم كوب ","none", (float)0, 11));
        items.add(new Element( 105, " ملعقة قهوة من العسل","none", (float)0.5, 11));
        items.add(new Element( 106, " ملعقة قهوة من العسل","none", (float)0.5, 11));
        items.add(new Element( 107, " الزيتون الاخضر خمس حبات ","none", (float)0.5, 11));
        items.add(new Element( 108, " قطعة الماجي ","none", (float)0.5, 11));
        items.add(new Element( 109, " كأس عصير الفواكه طبيعي","none", (float)1, 11));
        items.add(new Element( 110, " كأس حليب منزوع الدسم جزئيا","none", (float)1, 11));
        items.add(new Element( 111, " 1 موز","none", (float)1, 11));
        items.add(new Element( 112, " ملعقة قهوة من الجبن المبشور","none", (float)1, 11));
        items.add(new Element( 113, " 10غ من الشكولاطة","none", (float)1, 11));
        items.add(new Element( 114, " 15 حبة كرز أو نصف مانجو","none", (float)1, 11));
        items.add(new Element( 115, " 15 حبة عنب أو برقوق 100غ","none", (float)1, 11));
        items.add(new Element( 116, " 3 حبات تمر","none", (float)1, 11));
        items.add(new Element( 117, " برتقالة او إجاصة","none", (float)1, 11));
        items.add(new Element( 118, " ملعقة قهوة من الزبدة","none", (float)1, 11));
        items.add(new Element( 119, " ملعقة قهوة من القشطة","none", (float)1, 11));
        items.add(new Element( 120, " عصير الفاكهة : التفاح والبرتقال ","none", (float)1, 11));
        items.add(new Element( 121, " قطعتين شابورة أو 4 قطع بسكويت ","none", (float)1, 11));
        items.add(new Element( 122, " الأجبان: جبنة قليلة الدسم او فيتا ","none", (float)1, 11));
        items.add(new Element( 123, " كوب حليب خالي الدسم أو كوب لبن خالي الدسم أي منزوع ","none", (float)1, 11));
        items.add(new Element( 124, " كأس عصير الفواكه طبيعي","none", (float)1, 11));
        items.add(new Element( 125, " كأس حليب أو لبن قليل الدسم ","none", (float)1, 11));
        items.add(new Element( 126, " قهوة علي ","none", (float)1, 11));
        items.add(new Element( 127, " حليب بودره لكل ملعقه مليانه شوي ","none", (float)1, 11));
        items.add(new Element( 128, " كوفي ميت ملعقة طعام ","none", (float)1, 11));
        items.add(new Element( 129, " ملعقة السكر الصغيره فيها ","none", (float)1, 11));
        items.add(new Element( 130, " 1 توست اسمر ","none", (float)1, 11));
        items.add(new Element( 131, " رغيف صحي","none", (float)1, 11));
        items.add(new Element( 132, " ربع رغيف اسمر ","none", (float)1, 11));
        items.add(new Element( 133, " ملعقة قهوة من الزبدة","none", (float)1, 11));
        items.add(new Element( 134, " ملعقة قهوة من القشطة","none", (float)1, 11));
        items.add(new Element( 135, " جبنة قليلة الدسم او فيتا ","none", (float)1, 11));
        items.add(new Element( 136, " ملعقة جبنة سايلة ","none", (float)1, 11));
        items.add(new Element( 137, " شريحه وحده قليل الدسم 20 جرام ","none", (float)1, 11));
        items.add(new Element( 138, " جبن مثلث 14 جرام ","none", (float)1, 11));
        items.add(new Element( 139, " جبن التشدر ( ملعقة واحده) 10 جرام ","none", (float)1, 11));
        items.add(new Element( 140, " الزيتون الاسود 5 حبات ","none", (float)1, 11));
        items.add(new Element( 141, " بانكيك قطعه(خليط العلب)","none", (float)1, 11));
        items.add(new Element( 142, " 1 موز","none", (float)1, 11));
        items.add(new Element( 143, " 10غ من الشوكولاته","none", (float)1, 11));
        items.add(new Element( 144, " 15 حبة كرز أو نصف مانجو","none", (float)1, 11));
        items.add(new Element( 145, " 15 حبة عنب أو برقوق 100غ","none", (float)1, 11));
        items.add(new Element( 146, " 3 حبات تمر","none", (float)1, 11));
        items.add(new Element( 147, " الحجم الصغيربسكوت شاهي حبه ","none", (float)1, 11));
        items.add(new Element( 148, " بسكويت دايجستيف ","none", (float)1, 11));
        items.add(new Element( 149, " قطعتين جالكسي ","none", (float)1, 11));
        items.add(new Element( 150, " الفراوله 10 حبات فيها ","none", (float)1, 11));
        items.add(new Element( 151, " و لبن زبادي أكتيفيا الحجم الصغير ","none", (float)1, 11));
        items.add(new Element( 152, " صلصة الباربكيو ( علبة وحده) ","none", (float)1, 11));
        items.add(new Element( 153, " صوص حلو ","none", (float)1, 11));
        items.add(new Element( 154, " صلصة الخردل الحارة ","none", (float)1, 11));
        items.add(new Element( 155, " كتشب ( ربع كوب) ","none", (float)1, 11));
        items.add(new Element( 156, " مايونيز ملعقة طعام ","none", (float)1, 11));
        items.add(new Element( 157, " كأس حليب + ملعقتين قهوة من الكاكاو","none", (float)1.5, 11));
        items.add(new Element( 158, " عصير الليمون والكوكتيل ","none", (float)1.5, 11));
        items.add(new Element( 159, " 5/1 رغيف أو 2 توست ","none", (float)2, 11));
        items.add(new Element( 160, " 1 زبادي طبيعي 0% دسم ","none", (float)2, 11));
        items.add(new Element( 161, " 1 بيضة مسلوقة","none", (float)2, 11));
        items.add(new Element( 162, " 6 ملاعق أكل من الكورن فلكس","none", (float)2, 11));
        items.add(new Element( 163, " صدر دجاج مشوي بدون جلد 100غ ","none", (float)2, 11));
        items.add(new Element( 164, " 4 ملاعق كبيرة من المعكرونة، الأرز، القمح أو اللوبياء البيضاء","none", (float)2, 11));
        items.add(new Element( 165, " بطاطا حسب الرغبة بدون إضافات","none", (float)2, 11));
        items.add(new Element( 166, " 120غ من السمك أو جمبري ","none", (float)2, 11));
        items.add(new Element( 167, " شريحة لحم ديك رومي","none", (float)2, 11));
        items.add(new Element( 168, " بطاطس مسلوق أو مشوي متوسطة الحجم ","none", (float)2, 11));
        items.add(new Element( 169, " عدد 5 ملاعق رز أو عدس أو ذرة أو مكرونة ","none", (float)2, 11));
        items.add(new Element( 170, " جبنة بيضاء 20 % دسم ","none", (float)2, 11));
        items.add(new Element( 171, " كوب حليب قليل الدسم أو لبن كامل الدسم ","none", (float)2, 11));
        items.add(new Element( 172, " اللحوم: مقدار 100 غرام سمك ","none", (float)2, 11));
        items.add(new Element( 173, " كأس حليب أو لبن كامل الدسم ","none", (float)2, 11));
        items.add(new Element( 174, " عصير الكوكتيل ","none", (float)2, 11));
        items.add(new Element( 175, " قهوة ماي كوب 3 في واحد ","none", (float)2, 11));
        items.add(new Element( 176, " كابتشينو من حليب منزوع الدسم 230 ملي ","none", (float)2, 11));
        items.add(new Element( 177, " كابتشينو من حليب كامل الدسم 230 ملي ","none", (float)2, 11));
        items.add(new Element( 178, " 1 توست ابيض ","none", (float)2, 11));
        items.add(new Element( 179, " بيضة مسلوقة ","none", (float)2, 11));
        items.add(new Element( 180, " 6ملاعق أكل من الكورن فلكس","none", (float)2, 11));
        items.add(new Element( 181, " جبنة بيضاء 20 % دسم ","none", (float)2, 11));
        items.add(new Element( 182, " جبنه مثلثات ","none", (float)2, 11));
        items.add(new Element( 183, " المرتديلا الشريحه ","none", (float)2, 11));
        items.add(new Element( 184, " الفول 150 جرام ","none", (float)2, 11));
        items.add(new Element( 185, " وملعقة اكل فول سوداني ","none", (float)2, 11));
        items.add(new Element( 186, " قريباحبة مانجو ","none", (float)2, 11));
        items.add(new Element( 187, " البيتي فور ","none", (float)2, 11));
        items.add(new Element( 188, " شيره ملعقة طعام 1ملعقة طعام سكر ","none", (float)2, 11));
        items.add(new Element( 189, " زبادي قليل الدسم ","none", (float)2, 11));
        items.add(new Element( 190, " صدر دجاج مشوي بدون جلد 100غ ","none", (float)2, 11));
        items.add(new Element( 191, " 4 ملاعق كبيرة من المكرونة أو الأرز أو العدس أو الفول أو الذرة أو القمح أو اللوبياء البيضاء ","none", (float)2, 11));
        items.add(new Element( 192, " 120غ من السمك أو جمبري ","none", (float)2, 11));
        items.add(new Element( 193, " شريحة لحم ديك رومي","none", (float)2, 11));
        items.add(new Element( 194, " بطاطس مسلوق أو مشوي متوسطة الحجم ","none", (float)2, 11));
        items.add(new Element( 195, " شريحة بفتيك ","none", (float)2.5, 11));
        items.add(new Element( 196, " شيتوس مرسوم عليه نمر ","none", (float)2.5, 11));
        items.add(new Element( 197, " فطيرة لبنه بالزعتر ","none", (float)3, 11));
        items.add(new Element( 198, " صحن تبولة متوسط الحجم قليل الزيت ","none", (float)3, 11));
        items.add(new Element( 199, " الببسي العادي ","none", (float)3, 11));
        items.add(new Element( 200, " فطيرة لبنه بالزعتر ","none", (float)3, 11));
        items.add(new Element( 201, " بانكيك قطعه مصنوع بالبيت","none", (float)3, 11));
        items.add(new Element( 202, " ليز بالجبنة الفرنسية ","none", (float)3, 11));
        items.add(new Element( 203, " بوب كورن (1 كوب) ","none", (float)3, 11));
        items.add(new Element( 204, " اصبعين كتكات ","none", (float)3, 11));
        items.add(new Element( 205, " بياله الشاي مكسرات فيها ","none", (float)3, 11));
        items.add(new Element( 206, " معمول او ********ز الحبة ","none", (float)3, 11));
        items.add(new Element( 207, " مفروم لحم نص كوب دسم قليل ","none", (float)3, 11));
        items.add(new Element( 208, " صحن تبولة متوسط الحجم قليل الزيت ","none", (float)3, 11));
        items.add(new Element( 209, " 1.5ملعقة زيت ","none", (float)3, 11));
        items.add(new Element( 210, " تاكو حبه ","none", (float)3, 11));
        items.add(new Element( 211, " شريحة خبز أسمر+خس+طماطم+ علبة تونه طبيعي 80غ ","none", (float)3.5, 11));
        items.add(new Element( 212, " شوربه العدس 250 ملل  ","none", (float)3.5, 11));
        items.add(new Element( 213, " 1 كرواسون","none", (float)4, 11));
        items.add(new Element( 214, " صحن خس+خيار+فطر+طماطم+فلفل أحمر+ علبة 100غ تونة بدون زيت","none", (float)4, 11));
        items.add(new Element( 215, " 100غ من التونة بالزيت","none", (float)4, 11));
        items.add(new Element( 216, " عدد 7 ملاعق كبيرة بطاطس مقلية ","none", (float)4, 11));
        items.add(new Element( 217, " لحم بالعجين ","none", (float)4, 11));
        items.add(new Element( 218, " كاكاو بالحليب قليل الدسم 2% دسم 230 ملي ","none", (float)4, 11));
        items.add(new Element( 219, " قهوه (لاتيه او موكا) بالحليب 300 ملي ","none", (float)4, 11));
        items.add(new Element( 220, " الرغيف العادي ","none", (float)4, 11));
        items.add(new Element( 221, " 1 كرواسون","none", (float)4, 11));
        items.add(new Element( 222, " 100غ من التونة بالزيت","none", (float)4, 11));
        items.add(new Element( 223, " ايس كريم فانيلا ","none", (float)4, 11));
        items.add(new Element( 224, " اللوز 23 حبه ب ","none", (float)4, 11));
        items.add(new Element( 225, " أصبع التويكس الواحد ","none", (float)4, 11));
        items.add(new Element( 226, " كب كيك ","none", (float)4, 11));
        items.add(new Element( 227, " عدد 7 ملاعق كبيرة بطاطس مقلية ","none", (float)4, 11));
        items.add(new Element( 228, " لحم بالعجين ","none", (float)4, 11));
        items.add(new Element( 229, " برجر كينج سبايسي من برجر كينح ","none", (float)4, 11));
        items.add(new Element( 230, " بالدجاج او الجمبري ","none", (float)4, 11));
        items.add(new Element( 231, " البرجر الدجاج المشوي ","none", (float)4, 11));
        items.add(new Element( 232, " الفيليه المشوي 200 جم ","none", (float)4, 11));
        items.add(new Element( 233, " الباشميل ربع كوب ","none", (float)4, 11));
        items.add(new Element( 234, " جبنه الشيدر 40 جرام ","none", (float)4.5, 11));
        items.add(new Element( 235, " ماك تشكن نقتس ( 4 قطع ) ","none", (float)4.5, 11));
        items.add(new Element( 236, " 4/1 دجاجة مشوية بدون الجلد","none", (float)5, 11));
        items.add(new Element( 237, " عجة بيض ببيضتان+ 1 ملعقة قهوة زيت","none", (float)5, 11));
        items.add(new Element( 238, " مقدار 100 غرام لحم أو دجاج","none", (float)5, 11));
        items.add(new Element( 239, " عدد 4 قطع ورق عنب ","none", (float)5, 11));
        items.add(new Element( 240, " عدد 2 حبة فلافل ( طعمية ) كبيرة ","none", (float)5, 11));
        items.add(new Element( 241, " عدد 2 حبة فلافل ( طعمية ) كبيرة ","none", (float)5, 11));
        items.add(new Element( 242, " دونات كرسبي كريم )الحبه العاديه) ","none", (float)5, 11));
        items.add(new Element( 243, " وافل اي نوع 3بقلاوة الحبة ب ","none", (float)5, 11));
        items.add(new Element( 244, " ربع دجاجة مشوية بدون الجلد","none", (float)5, 11));
        items.add(new Element( 245, " مقدار 100 غرام لحم أو دجاج ","none", (float)5, 11));
        items.add(new Element( 246, " عدد 4 قطع ورق عنب ","none", (float)5, 11));
        items.add(new Element( 247, " سبرنغ روول باللحم حبه ","none", (float)5, 11));
        items.add(new Element( 248, " مكرونة بالباشميل المئة غرام ","none", (float)5, 11));
        items.add(new Element( 249, " وصينية البطاطس بدون باشميل ولا قلي","none", (float)5, 11));
        items.add(new Element( 250, " بطاطا مقليه ( حجم صغير) ","none", (float)5.5, 11));
        items.add(new Element( 251, " قطعة كيك صغيرة ","none", (float)6, 11));
        items.add(new Element( 252, " قطعة بيتزا ","none", (float)6, 11));
        items.add(new Element( 253, " قطعة كيك صغيرة ","none", (float)6, 11));
        items.add(new Element( 254, " فطيرة التفاح من ماكدونالدز ","none", (float)6, 11));
        items.add(new Element( 255, " قطعة بيتزا ","none", (float)6, 11));
        items.add(new Element( 256, " اندومي (شعيريه مقليه)الكيس الواحد ","none", (float)6, 11));
        items.add(new Element( 257, " صوص كريمي ","none", (float)6, 11));
        items.add(new Element( 258, " ماكدونالدز همبرجر ","none", (float)6, 11));
        items.add(new Element( 259, " البرجر اللحم المشوي ","none", (float)6, 11));
        items.add(new Element( 260, " ايسكريم الكره الصغيره فيها ","none", (float)7, 11));
        items.add(new Element( 261, " ساندويتش كباب ","none", (float)7, 11));
        items.add(new Element( 262, " حلقات بصل 8 حلقات ","none", (float)7, 11));
        items.add(new Element( 263, " تشيز برجر ","none", (float)7.5, 11));
        items.add(new Element( 264, " كروسان باللحم المفروم ","none", (float)8, 11));
        items.add(new Element( 265, " بروست الدجاج ربع دجاجة ","none", (float)8, 11));
        items.add(new Element( 266, " الصبة (سنتدويتش فلافل) ","none", (float)8, 11));
        items.add(new Element( 267, " كروسان باللحم المفروم ","none", (float)8, 11));
        items.add(new Element( 268, " بروست الدجاج ربع دجاجة ","none", (float)8, 11));
        items.add(new Element( 269, " تشيكن نقتس 6 قطع ","none", (float)8, 11));
        items.add(new Element( 270, " ساندوتش شاورما ","none", (float)9, 11));
        items.add(new Element( 271, " ساندوتش شاورما ","none", (float)9, 11));
        items.add(new Element( 272, " بطاطا مقليه ( حجم وسط ) ","none", (float)9, 11));
        items.add(new Element( 273, " كنتاكي زينجر برجر ","none", (float)9, 11));
        items.add(new Element( 274, " بيج ماك ( بدون الصوص ) ","none", (float)11, 11));
        items.add(new Element( 275, " دبل تشيز برجر ","none", (float)11.5, 11));
        items.add(new Element( 276, " ساندوتش هوت دوغ ","none", (float)11.5, 11));
        items.add(new Element( 277, " ماك فلوري بالاوريو ( حجم وسط ) من ماكدونالدز ","none", (float)13, 11));
        items.add(new Element( 278, " ماكدونالدز بيج ماك ( بدون الصوص )","none", (float)13.5, 11));
        items.add(new Element( 279, " بطاطا مقليه ( حجم كبير) ","none", (float)13.5, 11));
        items.add(new Element( 280, " حساء الفطر كوب ","none", (float)15, 11));
        items.add(new Element( 281, " حساء الطماطم الطازجه كوب واحد ","none", (float)17, 11));


        return items;
    }

}
