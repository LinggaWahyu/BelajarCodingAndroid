package com.example.mylistview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ViewHolder {

    private TextView txtName;
    private TextView txtDescription;
    private ImageView imgPhoto;

    ViewHolder(View view) {
        txtName = view.findViewById(R.id.txt_name);
        txtDescription = view.findViewById(R.id.txt_description);
        imgPhoto = view.findViewById(R.id.img_photo);
    }

    void bind(Hero hero) {
        txtName.setText(hero.getName());
        txtDescription.setText(hero.getDescription());
        imgPhoto.setImageResource(hero.getPhoto());
    }
}
