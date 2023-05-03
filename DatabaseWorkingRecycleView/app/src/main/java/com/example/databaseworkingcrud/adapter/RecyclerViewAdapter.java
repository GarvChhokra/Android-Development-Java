package com.example.databaseworkingcrud.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databaseworkingcrud.NewPage;
import com.example.databaseworkingcrud.R;
import com.example.databaseworkingcrud.model.Contact;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Contact> contactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }


    // Where to get the single card as ViewHolder Object
    // Kis chiz ko baar baar dikhana hai will be on onCreateViewHolder
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

        return new ViewHolder(view);
    }


    // What will happen after we create viewHolder Object
    // mil gya viewHolder phir kya karna hai
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        // what will write in that row like what will be the text, image
        Contact contact=contactList.get(position);

        holder.contactName.setText(contact.getName());
        holder.contactNumber.setText(contact.getPhoneNumber());
        holder.iconImage.setImageResource(R.drawable.ic_launcher_background);

    }


    // how many items?
    @Override
    public int getItemCount() {
        return contactList.size();
    }


    // creating class for ViewHolder which is giving error
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView contactName;
        public TextView contactNumber;
        public ImageView iconImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            contactName=itemView.findViewById(R.id.textView2);
            contactNumber=itemView.findViewById(R.id.textView3);
            iconImage=itemView.findViewById(R.id.imageView);


            iconImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("Name", "onClick: Clicked..");


            int position=this.getAdapterPosition();
            int exact_pos=position+1;
            Contact contact=contactList.get(position);
            String name =contact.getName();
            String number=contact.getPhoneNumber();
            Toast.makeText(context, "Position is: "+exact_pos+" Name: "+name+" Phone Number: "
                    +number, Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(context, NewPage.class);
            intent.putExtra("R_name",name);
            intent.putExtra("R_phoneNumber",number);
            context.startActivity(intent);

        }
    }


}
