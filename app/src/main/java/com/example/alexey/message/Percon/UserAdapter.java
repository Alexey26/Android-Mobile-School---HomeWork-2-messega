package com.example.alexey.message.Percon;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexey.message.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by vladimir on 29.03.18.
 */

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public class UserListViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;
        CircleImageView circleImageView;

        public UserListViewHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.textView_name_list);
            circleImageView = itemView.findViewById(R.id.profile_image_list);
        }

        public void setName(String nameText) {
            nameView.setText(nameText);
        }

        public void setCircleImageView(Bitmap bitmap) {
            circleImageView.setImageBitmap(bitmap);
        }
    }

    List<Person> persons;
    public UserAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.users1, null);
            return new UserListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        UserListViewHolder userListViewHolder = (UserListViewHolder) holder;
        userListViewHolder.setName(persons.get(position).getfullName());
        userListViewHolder.setCircleImageView(persons.get(position).getSelectedImage());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }







//    public class UserList2ViewHolder extends RecyclerView.ViewHolder {
//        TextView nameView;
//        CircleImageView circleImageView;
//        public UserList2ViewHolder(View itemView) {
//            super(itemView);
//            nameView = itemView.findViewById(R.id.textView_name_list);
//            circleImageView = itemView.findViewById(R.id.profile_image_list);
//
//        }
//
//        public void setName(String nameText) {
//            nameView.setText(nameText);
//        }
//
//    }
}
