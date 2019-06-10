package com.piyu.uidashboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public  class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.ViewHolder>{
    private Context context;
    private List<jsonResponse> myData;

    public CustomAdapter(Context context, List<jsonResponse> myData) {
        this.context = context;
        this.myData = myData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list,viewGroup,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.codename.setText(myData.get(i).getCodename());
        viewHolder.name.setText(myData.get(i).getName());
        viewHolder.startdate.setText(myData.get(i).getStartdate());
        viewHolder.enddate.setText(myData.get(i).getEnddate());

    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder{
        public TextView codename;
        public TextView name;
        public TextView startdate;
       public TextView enddate;
       public ViewHolder(View itemView)
       {
           super(itemView);
           codename=(TextView) itemView.findViewById(R.id.codename);
           name=(TextView) itemView.findViewById(R.id.name);
           startdate=(TextView) itemView.findViewById(R.id.start);
           enddate=(TextView) itemView.findViewById(R.id.end);
       }
    }
}

