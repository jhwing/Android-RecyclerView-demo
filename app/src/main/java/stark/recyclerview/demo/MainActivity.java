package stark.recyclerview.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] sList = new String[]{
            "item a",
            "item b",
            "item c",
            "item d",
            "item e",
            "item f",
            "item g",
            "item h"};

    Toolbar toolbar;

    RecyclerView recyclerView;

    MyAdapter myAdapter;

    LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

        mInflater = LayoutInflater.from(this);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(mInflater.inflate(R.layout.view_list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.itemText.setText(sList[position]);
        }

        @Override
        public int getItemCount() {
            return sList.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView itemText;

            public MyViewHolder(View itemView) {
                super(itemView);
                itemText = (TextView) itemView.findViewById(R.id.itemText);
            }
        }
    }
}
