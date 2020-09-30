package com.example.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MyViewHolder> {

    Context ct;
    List<Student> studentList;

    public MyDataAdapter(MainActivity mainActivity, List<Student> students) {
        ct = mainActivity;
        studentList = students;
    }

    @NonNull
    @Override
    public MyDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.row_deisgn,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDataAdapter.MyViewHolder holder, int position) {

        final Student student = studentList.get(position);
        holder.rroll.setText(student.getRollNumber());
        holder.rname.setText(student.getName());
        holder.rmail.setText(student.getMailID());
        holder.rphone.setText(student.getPhoneNumber());
        holder.rdob.setText(student.getDOB());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MainActivity.dataBase.myDao().Delete(student);

                MainActivity.viewModel.Delete(student);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView rname,rmail,rphone,rroll,rdob;
        ImageView edit,delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            rname = itemView.findViewById(R.id.readname);
            rmail = itemView.findViewById(R.id.readmail);
            rphone = itemView.findViewById(R.id.readphone);
            rdob = itemView.findViewById(R.id.readdob);
            rroll = itemView.findViewById(R.id.readroll);
            edit = itemView.findViewById(R.id.update);
            delete = itemView.findViewById(R.id.delete);


        }
    }
}
