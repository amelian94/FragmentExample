package com.neonidapps.fragmentexample.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.neonidapps.fragmentexample.R;


public class DataFragment extends Fragment {

    private EditText dataText;
    private Button moverTexto;
    private DataTransfer callback;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            callback = (DataTransfer) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString() + "No se ha podido llevar a cabo el casteo a DataTransfer.");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        moverTexto = (Button) view.findViewById(R.id.buttonMoverText);
        dataText = (EditText) view.findViewById(R.id.editTextData);

        moverTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendText(dataText.getText().toString());
            }
        });

        return view;
    }

    public interface DataTransfer {
        void sendText(String text);
    }


}
