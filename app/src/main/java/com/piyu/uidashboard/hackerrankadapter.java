package com.piyu.uidashboard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

class hackerrankadapter  extends RecyclerView.Adapter<hackerrankadapter.ViewHolder> {

    private Context context;
    private List<hackerrankresponse> mydata;

    hackerrankadapter(Context context, List<hackerrankresponse> mydata) {
        this.context = context;
        this.mydata = mydata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hackerrank,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
     final hackerrankresponse getDataAdapter1 =  mydata.get(i);
        viewHolder.hackerrankname.setText(mydata.get(i).getName());
        viewHolder.desc.setText(mydata.get(i).getDesc());
        viewHolder.startdate.setText(mydata.get(i).getStartdate());
        viewHolder.enddate.setText(mydata.get(i).getEnddate());


        viewHolder.gotolink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String link="https://www.hackerrank.com/"+getDataAdapter1.getUrlslug();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView hackerrankname;
        public TextView desc;
        public TextView startdate;
        public TextView enddate;
        public Button  gotolink;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hackerrankname=(TextView )itemView.findViewById(R.id.hackerrankname);
            desc=(TextView)itemView.findViewById(R.id.hackerrankdesc);
            startdate=(TextView) itemView.findViewById(R.id.hackerrankstart);
            enddate=(TextView)itemView.findViewById(R.id.hackerrankend);
            gotolink=(Button)itemView.findViewById(R.id.linkhackerrank);

        }
    }
}

