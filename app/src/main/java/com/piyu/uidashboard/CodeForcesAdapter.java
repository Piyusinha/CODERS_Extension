package com.piyu.uidashboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class CodeForcesAdapter extends RecyclerView.Adapter<CodeForcesAdapter.ViewHolder> {
    private Context context;
    private List<CodeForcesResponse> mydata;

    public CodeForcesAdapter(Context context, List<CodeForcesResponse> mydata) {
        this.context = context;
        this.mydata = mydata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listcodeforces,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mydata.get(i).getName());
        viewHolder.writer.setText(mydata.get(i).getWriters());
        viewHolder.startdate.setText(mydata.get(i).getStart());
        viewHolder.startin.setText(mydata.get(i).getBeforestart());
        viewHolder.legth.setText(mydata.get(i).getLength());
    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView writer;
        public TextView startdate;
        public TextView legth;
        private TextView startin;

        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.codeforcesname);
            writer=(TextView) itemView.findViewById(R.id.writername);
            startdate=(TextView) itemView.findViewById(R.id.forcesstart);
            legth=(TextView) itemView.findViewById(R.id.length);
            startin =(TextView) itemView.findViewById(R.id.beforestart);
        }
    }
}
