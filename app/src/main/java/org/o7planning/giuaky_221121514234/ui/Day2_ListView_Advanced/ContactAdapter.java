package org.o7planning.giuaky_221121514234.ui.Day2_ListView_Advanced;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import org.o7planning.giuaky_221121514234.R;
import org.o7planning.giuaky_221121514234.ui.Day2_ListView.ContactModel;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private Context mContext;
    private List<ContactModel> listContact;
    private IOnChildItemClick iOnChildItemClick;
    public ContactAdapter(Context context, List<ContactModel> listContact){
        this.mContext = context;
        this.listContact = listContact;
    }

    public void  registerChildItemClick(IOnChildItemClick iOnChildItemClick){
        this.iOnChildItemClick = iOnChildItemClick;
    }
    public void unRegisterChildItemClick(){
        this.iOnChildItemClick = null;
    }
    @Override
    public int getCount(){
        return listContact.size();
    }
    @Override
    public Object getItem(int i){
        return listContact.get(i);
    }
    @Override
    public long getItemId(int i){
        return i;
    }
    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup){
        View rowView = convertView;
        ContactModel contact = listContact.get(i);
        if (rowView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            rowView = inflater.inflate(R.layout.item_contact_advanced, viewGroup, false);

            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView)rowView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView)rowView.findViewById(R.id.tvPhone);
            holder.ivAvatar = (ImageView)rowView.findViewById(R.id.ivAvatar);
            holder.tvName = (TextView)rowView.findViewById(R.id.tvName);
            holder.btCall = (ImageView)rowView.findViewById(R.id.btCall);
            holder.btEdit2 = (ImageView)rowView.findViewById(R.id.btEdit2);
            rowView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.tvName.setText(listContact.get(i).getName());
        holder.tvPhone.setText(listContact.get(i).getPhone());
        holder.ivAvatar.setImageResource(listContact.get(i).getImage());
        if (contact.getImage() != 0) {
            holder.ivAvatar.setImageResource(contact.getImage());
        } else {
            holder.ivAvatar.setImageResource(R.drawable.anh_2);
        }
        holder.btCall.setOnClickListener(null);
        holder.btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(i);
            }
        });
        holder.btEdit2.setOnClickListener(null);
        holder.btEdit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iOnChildItemClick != null) {
                    iOnChildItemClick.onEditClick(contact);
                }
            }
        });

        return rowView;
    }

    private void onCall(int position) {
        ContactModel contact = listContact.get(position);
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contact.getPhone()));
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CALL_PHONE}, 1);
            return;
        }
        mContext.startActivity(intent);
    }
    static class ViewHolder {
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
        ImageView btCall;
        ImageView btEdit2;
    }
}
