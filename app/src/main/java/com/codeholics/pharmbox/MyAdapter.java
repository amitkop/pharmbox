package com.codeholics.pharmbox;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        ArrayList<database> list;
        Context context;


        public MyAdapter(Context context, ArrayList<database> list)
        {
            this.list=list;
            this.context=context;

        }



        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder, viewGroup, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
            final database model=list.get(i);
            myViewHolder.medicine.setText(list.get(i).getMedicine());
            myViewHolder.disease.setText(list.get(i).getDisease());
            myViewHolder.shopname.setText(list.get(i).getShopname());
            myViewHolder.address.setText(list.get(i).getAddress());


        }

        @Override
        public int getItemCount() {
            return list.size();
        }


        class MyViewHolder extends RecyclerView.ViewHolder  {
            TextView medicine,disease,shopname,address,desc1;



            public MyViewHolder(@NonNull final View itemView) {
                super(itemView);
                medicine = itemView.findViewById(R.id.med);
                disease = itemView.findViewById(R.id.disease);
                shopname = itemView.findViewById(R.id.shopname);
                address=itemView.findViewById(R.id.shopaddress);
                desc1=itemView.findViewById(R.id.textView);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            database clickedDataItem=list.get(pos);
                            Intent inte= new Intent(context,desc_activity.class);
                            inte.putExtra("descrption",clickedDataItem);
                            context.startActivity(inte);
                        }
                    }
                });

            }


        }



}
