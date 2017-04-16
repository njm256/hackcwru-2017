package com.example.nicholas.stalldoor;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.CommentViewHolder> {
    private static int viewHolderCount;
    final private ListItemClickListener mOnClickListener;
    private ArrayList<Content> comments;

    public interface ListItemClickListener {
        void onListenItemClick(int clickedItemIndex);
    }

    public ContentAdapter(int numberOfItems, ListItemClickListener listener) {
        mOnClickListener = listener;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.comment_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachImmediately);
        CommentViewHolder viewHolder = new CommentViewHolder(view);
        return viewHolder;

    }

    @Override
    public int getItemCount() {
        if (comments == null) {
            return 0;
        }
        return comments.size();
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Content curComment = comments.get(position);
        if (curComment != null) {
            holder.commentPreview.setText(curComment.getBody());
            holder.downvotes.setText(String.valueOf(curComment.getDownvotes()));
            holder.upvotes.setText(String.valueOf(curComment.getUpvotes()));
        }
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView commentPreview;
        TextView upvotes;
        TextView downvotes;
        ImageButton upvote;
        ImageButton downvote;
        public CommentViewHolder(View itemView) {
            super(itemView);
            commentPreview = (TextView)itemView.findViewById(R.id.tv_comment_preview);
            upvotes = (TextView)itemView.findViewById(R.id.num_thumbs_up);
            downvotes = (TextView)itemView.findViewById(R.id.num_thumbs_down);
            upvote = (ImageButton)itemView.findViewById(R.id.image_thumbs_up);
            downvote = (ImageButton)itemView.findViewById(R.id.image_thumbs_down);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();

            mOnClickListener.onListenItemClick(clickedPosition);
        }
    }

    public void setComments(ArrayList<Content> newComments) {
        comments = newComments;
    }

}
