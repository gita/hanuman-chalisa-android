package com.nandi.hanuman.chalisa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * RadhaKrishna
 */

public class MantraList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list;
    private FirebaseAnalytics mFirebaseAnalytics;
    String[] itemname = {
            "Hanuman Chalisa\nShri Hanuman Chalisa",
            "Marut Nandan Mantra\nMarut Nandan Namo Namah",
            "Shree Ram Jay Ram Jay Jay Ram\nShree Ram Jay Ram Jay Jay Ram",
            "Om Mantra\nAum",
            "Om Hum Hanumate\nOm Hum Hanumate Namo Namaha",
            "Om Anjaneyaya Mantra\nOm Anjaneyaya Namah",
            "Shree Ram Dutaya Namah \nOm Aim Bhreem Hanumate\nShree Ram Dutaya Namah",
//            "Om Namah Shivaya Mantra\nOm Namah Shivaya",
//            "Shani Dev Mantra \nOm Neelanjanan Samabhasam Raviputram Yamagrajam, Chaaya Martand Sambhutam Tam Namami Shanaishcharam",
//            "Shree Krishna Mantra\nOm Namo Bhagwate Vasudevaya",
//            "Sai Baba Mantra\nOm Shri Sainathaya Namaha"


    };
    Integer[] imgid = {
            R.drawable.hanuman1,
            R.drawable.hanuman2,
            R.drawable.hanuman3,
            R.drawable.om,
            R.drawable.hanuman4,
            R.drawable.hanuman5,
            R.drawable.hanuman6,
//            R.drawable.list8,
//            R.drawable.list9,
//            R.drawable.list10,
//            R.drawable.list11
    };

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.mantra_list);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        //ListView listView = (ListView) findViewById(R.id.sites_list);
        //listView.setOnItemClickListener(this);
        CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid);
        list = (ListView) findViewById(R.id.mantras_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> l, View v, int position, long id) {


        Intent intent = new Intent();


        switch (position) {
            case 0:
                intent.setClass(this, HanumanChalisa.class);
                startActivity(intent);

                break;
            case 1:
                intent.setClass(this, HanumanMantra.class);
                startActivity(intent);

                break;
            case 2:
                intent.setClass(this, ShreeRamMantra.class);
                startActivity(intent);

                break;
            case 3:
                intent.setClass(this, OmMantra.class);
                startActivity(intent);

                break;
            case 4:
                intent.setClass(this, OmHumHanumate.class);
                startActivity(intent);

                break;
            case 5:
                intent.setClass(this, OmAnjaneyaMantra.class);
                startActivity(intent);

                break;
            case 6:
                intent.setClass(this, ShreeRamDutayaNamah.class);
                startActivity(intent);

                break;
//            case 7:
//                intent.setClass(this, OmNamahShivayaMantra.class);
//                startActivity(intent);
//
//                break;
//            case 8:
//                intent.setClass(this, ShaniMantra.class);
//                startActivity(intent);
//
//                break;
//            case 9:
//                intent.setClass(this, ShreeKrishnaMantra.class);
//                startActivity(intent);
//
//
//                break;
//            case 10:
//                intent.setClass(this, SaiBabaMantra.class);
//                startActivity(intent);
//
//
//                break;
            default:
                intent.setClass(this, HanumanChalisa.class);
                startActivity(intent);

                break;
        }
    }

}
