package com.example.tutorial_mvvm.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial_mvvm.R;
import com.example.tutorial_mvvm.model.Person;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<Person> mPresonList;

    public UserAdapter(List<Person> mPresonList) {
        this.mPresonList = mPresonList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person = mPresonList.get(position);
        if(person == null){
            return;
        }
        holder.imgUser.setImageResource(person.getImgAvt());
        holder.nameUser.setText(person.getName());
        holder.titleUser.setText(person.getTitle());
    }

    @Override
    public int getItemCount() {
        if(mPresonList!=null){
            return mPresonList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgUser;
        TextView nameUser,titleUser;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.imgUser);
            nameUser = itemView.findViewById(R.id.nameUser);
            titleUser = itemView.findViewById(R.id.titleUser);
        }
    }
}
