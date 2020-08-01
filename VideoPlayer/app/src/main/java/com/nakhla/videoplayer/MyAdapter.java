package com.nakhla.videoplayer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<VideoHolder> {

    private Context context;
    ArrayList<File> videoArrayList;

    public MyAdapter(Context context, ArrayList<File> videoArrayList) {
        this.context = context;
        this.videoArrayList = videoArrayList;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent,false);

        return new VideoHolder(mView);
    }

    /**
     * For Showing names and Thumbnails of videos
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final VideoHolder holder, int position) {
        try{
            holder.txtFileName.setText(MainActivity.fileArrayList.get(position).getName());
            //Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(videoArrayList.get(position).getPath(), MediaStore.Images.Thumbnails.MINI_KIND);

            Glide.with(context)
                    .load(videoArrayList.get(position).getPath())
                    .override(200, 200)// or URI/path
                    .into(holder.imageThumb); //imageview to set thumbnail to
            //holder.imageThumb.setImageBitmap(bitmap);

            //Glide.with(holder.imageThumb.getContext()).load(bitmap).override(200, 200).fitCenter().into(holder.imageThumb);

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,CustomPlayer.class);
                    intent.putExtra("position",holder.getAdapterPosition());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
        catch (Exception e){
            Toast.makeText(context,"No files",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        if (videoArrayList.size() > 0){
            return videoArrayList.size();
        }
        else return 1;
    }
}

class VideoHolder extends RecyclerView.ViewHolder{

    TextView txtFileName;
    ImageView imageThumb;
    CardView mCardView;

    VideoHolder(View view){
        super(view);

        txtFileName = view.findViewById(R.id.txt_file_name);
        imageThumb = view.findViewById(R.id.image_view_thumbnail);
        mCardView = view.findViewById(R.id.m_card_view);

    }
}
