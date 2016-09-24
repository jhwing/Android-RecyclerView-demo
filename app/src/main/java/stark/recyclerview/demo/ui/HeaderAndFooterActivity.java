package stark.recyclerview.demo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import stark.android.appbase.base.BaseSubToolbarActivity;
import stark.recyclerview.demo.R;
import stark.recyclerview.demo.lib.HeaderAndFooterRecyclerViewAdapter;
import stark.recyclerview.demo.lib.RecyclerViewUtils;

/**
 * Created by jihongwen on 16/9/8.
 */

public class HeaderAndFooterActivity extends BaseSubToolbarActivity {

    String[] sList = new String[]{
            "item a",
            "item b",
            "item c",
            "item d",
            "item e",
            "item f",
            "item g"
    };

    LayoutInflater mInflater;

    MyAdapter myAdapter;

    RecyclerView recyclerView;

    HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_and_footer);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mInflater = LayoutInflater.from(this);
        myAdapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(myAdapter);
        recyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);

        View header = LayoutInflater.from(this).inflate(R.layout.view_header, null);
        RecyclerViewUtils.setHeaderView(recyclerView, header);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(mInflater.inflate(R.layout.view_list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.button.setText(sList[position]);
        }

        @Override
        public int getItemCount() {
            return sList.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public Button button;

            public ViewHolder(View itemView) {
                super(itemView);
                button = (Button) itemView.findViewById(R.id.itemButton);
            }
        }
    }

}
