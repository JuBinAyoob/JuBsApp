package jubin.jubscreation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jubin on 11/7/17.
 */


public class FragmentAdd extends Fragment {

    EditText id,name,mobnumber;
    Button submit;

    public FragmentAdd() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.frag_add, container, false);

        id= (EditText) v.findViewById(R.id.id);
        name= (EditText) v.findViewById(R.id.name);
        mobnumber= (EditText) v.findViewById(R.id.mobnumber);
        submit=(Button) v.findViewById(R.id.submit);

        //final int strid=Integer.parseInt(id.getText().toString());


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strname=name.getText().toString();
                String strmobnum=mobnumber.getText().toString();

                DatabaseHandler db = new DatabaseHandler(getActivity());

                /**
                 * CRUD Operations
                 * */
                // Inserting Contacts
                Log.e("JuBs msg", "Inserting ..");
                db.addContact(new Contact(strname,strmobnum));

                // Reading all contacts
                Log.d("JuBs msg", "Reading all contacts..");
                List<Contact> contacts = db.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.e("JuBs msg", log);
                }

            }
        });
        // Inflate the layout for this fragment
        return v;
    }

}