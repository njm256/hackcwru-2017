package com.example.nicholas.stalldoor;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements ContentAdapter.ListItemClickListener {

    private ContentAdapter adapter;
    private static int NUM_LIST_ITEMS;
    private RecyclerView mCommentsList;
    private ArrayList<Content> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comments = new ArrayList<Content>();
        Resources res = getResources();
        String[] bareComments = res.getStringArray(R.array.tv_comments);
        Random rand = new Random();
        for (String s : bareComments) {
            comments.add(new Content(s, rand.nextInt(30) + 15, rand.nextInt(10)+4));
        }
        NUM_LIST_ITEMS = comments.size();

        mCommentsList = (RecyclerView)findViewById(R.id.rv_texts);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mCommentsList.setLayoutManager(manager);
        adapter = new ContentAdapter(NUM_LIST_ITEMS, this);
        adapter.setComments(comments);
        mCommentsList.setAdapter(adapter);

    }

    @Override
    public void onListenItemClick(int clickedItemIndex) {
        // TODO: open new activity
        // TODO: make the new activity
    }
}
