package com.STc.socialtechnocrats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.STc.socialtechnocrats.models.GalleryAdapter;
import com.STc.socialtechnocrats.models.GalleryItem;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    RecyclerView galleryRecycler;
    GalleryAdapter galleryAdapter;
    ArrayList<GalleryItem> galleryItems;
    public GalleryFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_gallery_fragment, container, false);

        galleryRecycler = view.findViewById(R.id.galleryRecycler);
        galleryRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));

        galleryItems = new ArrayList<>();
        // Sample data
        galleryItems.add(new GalleryItem("Tech Fest", R.drawable.img));
        galleryItems.add(new GalleryItem("Cultural Night", R.drawable.img_1));
        galleryItems.add(new GalleryItem("Workshop", R.drawable.img_2));

        galleryAdapter = new GalleryAdapter(getContext(), galleryItems);
        galleryRecycler.setAdapter(galleryAdapter);

        return view;
    }
}