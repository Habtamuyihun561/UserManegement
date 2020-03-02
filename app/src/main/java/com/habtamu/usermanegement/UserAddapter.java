package com.habtamu.usermanegement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAddapter extends RecyclerView.Adapter<UserAddapter.UserHolder>{
    Context context;
    ArrayList<Model> model;
     String usersName,password;




    public UserAddapter(Context cxt,ArrayList<Model> model) {
        this.context=cxt;
        this.model=model;

    }
    @Override
    public UserHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_layout,null);
        UserHolder holder=new UserHolder(view);
    return holder;
    }

    @Override
    public void onBindViewHolder(final UserHolder userHolder, int position) {
    userHolder. fname.setText(model.get(position).getFullname());
   userHolder.email.setText(model.get(position).getEmail());
    userHolder.setItemClickListener(new ItemClickListener() {
        @Override
        public void onItemClicked(View view, int index) {

                 // int pos=userHolder.getAdapterPosition();
            Intent intent=new Intent(context,UserDetailActivity.class);
            intent.putExtra("FULLNAME",model.get(index).getFullname());
            intent.putExtra("USERNAME",model.get(index).getUsername());
            intent.putExtra("EMAIL",model.get(index).getEmail());
            intent.putExtra("PASSWORD",model.get(index).getPassword());
            intent.putExtra("PHONENUMBER",model.get(index).getPhon_number());
            intent.putExtra("GENDER",model.get(index).getGender());
            context.startActivity(intent);
        }
    });
    SharedPreferences sharedPreferences=context.getSharedPreferences("MyData",Context.MODE_PRIVATE);{
        usersName=sharedPreferences.getString("USERNAMEV",null) ;
        password=sharedPreferences.getString("USERPASSWORDV",null);
        }
    userHolder.setItemOnLongClickListener(new ItemOnLongClickListener(){
        @Override
        public void onLongClickListner(View view, int id) {

            //int pos = userHolder.getAdapterPosition();
            Model ml = model.get(id);
            if (ml.getUsername().equals(usersName) && ml.getPassword().equals(password)) {
                Toast.makeText(context, "loged user can not be deleted", Toast.LENGTH_LONG).show();
            } else {
                model.remove(id);
                notifyItemRemoved(id);

                Toast.makeText(context, "one user deleted", Toast.LENGTH_LONG).show();
            }
            return;
        }});

    }


    @Override
    public int getItemCount() {
        return model.size();
    }



    class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        ImageView imageView;
        TextView fname;
        TextView email;
        ItemClickListener itemClickListener;
        ItemOnLongClickListener itemOnLongClickListener;
        public UserHolder( View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.user_image);
            fname=(TextView)itemView.findViewById(R.id.user_fullname);
            email=(TextView)itemView.findViewById(R.id.emailOfuser);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
        public  void setItemOnLongClickListener(ItemOnLongClickListener itemOnLongClickListener){
            this.itemOnLongClickListener=itemOnLongClickListener;
        }
        public  void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener=itemClickListener;
        }


        

        @Override
        public void onClick(View v) {
this.itemClickListener.onItemClicked(v,getLayoutPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            this.itemOnLongClickListener.onLongClickListner(v, getLayoutPosition());
            return true;
        }


    }
}
