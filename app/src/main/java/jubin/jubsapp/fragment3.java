package jubin.jubscreation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jubin on 9/7/17.
 */

public class fragment3 extends Fragment {

    RecyclerView recyclerView;

    public fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.frag_three, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

        List<ItemDetails> itemDetailses=new ArrayList<>();

        ItemDetails obj1=new ItemDetails();
        obj1.setTitle("one");
        obj1.setDetail("first_details");
        obj1.setImage(R.drawable.one);
        itemDetailses.add(obj1);

        ItemDetails obj2=new ItemDetails();
        obj2.setTitle("two");
        obj2.setDetail("Second_details");
        obj2.setImage(R.drawable.two);
        itemDetailses.add(obj2);

        ItemDetails obj3=new ItemDetails();
        obj3.setTitle("three");
        obj3.setDetail("Third_details");
        obj3.setImage(R.drawable.three);
        itemDetailses.add(obj3);

        // LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),3);
        Adapter adapter=new Adapter(itemDetailses);

        //recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return v;
    }

}