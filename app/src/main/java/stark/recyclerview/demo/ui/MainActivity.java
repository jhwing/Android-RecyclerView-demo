package stark.recyclerview.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import stark.android.appbase.base.BaseToolbarActivity;
import stark.recyclerview.demo.ListBean;
import stark.recyclerview.demo.R;

public class MainActivity extends BaseToolbarActivity {

    ListBean[] sList = new ListBean[]{
            new ListBean("header and footer view", HeaderAndFooterActivity.class),
            new ListBean("multi types list", MultiTypesListActivity.class),
            new ListBean("header and footer view", HeaderAndFooterActivity.class)
    };

    RecyclerView recyclerView;

    MyAdapter myAdapter;

    LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            holder.button.setText(sList[position].title);
        }

        @Override
        public int getItemCount() {
            return sList.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            public Button button;

            public MyViewHolder(View itemView) {
                super(itemView);
                button = (Button) itemView.findViewById(R.id.itemButton);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, sList[getLayoutPosition()].clazz));
                    }
                });
            }
        }
    }
}
