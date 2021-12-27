package com.example.myfirstapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Activity mContext;
    List<Vet> VetList;

    public ListAdapter(Activity mContext,List<Vet> VetList){
        super(mContext,R.layout.list_item,VetList);
        this.mContext = mContext;
        this.VetList = VetList;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item,null,true);

        TextView tvName = listItemView.findViewById(R.id.tvName);
        TextView tvEmail = listItemView.findViewById(R.id.tvEmail);

        Vet vet = VetList.get(position);

        tvName.setText(vet.getFullname() + "  -  ");
        tvEmail.setText(vet.getEmail());

        return listItemView;
    }
}
