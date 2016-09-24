package stark.recyclerview.demo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import stark.android.appbase.base.BaseSubToolbarActivity;
import stark.android.appbase.widget.recyclerview.BaseItem;
import stark.android.appbase.widget.recyclerview.MultiTypeListAdapter;
import stark.recyclerview.demo.R;
import stark.recyclerview.demo.ui.adapter.ItemViewFactory;
import stark.recyclerview.demo.ui.adapter.Sample;
import stark.recyclerview.demo.ui.adapter.ViewType;

/**
 * Created by jihongwen on 16/9/24.
 */

public class MultiTypesListActivity extends BaseSubToolbarActivity {

    Sample[] sList = new Sample[]{
            new Sample("item a", "text"),
            new Sample("item a", "image"),
            new Sample("item a", "video"),
            new Sample("item a", "text"),
            new Sample("item a", "image"),
            new Sample("item a", "video")
    };

    RecyclerView recyclerView;

    SampleListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_types_list);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SampleListAdapter();
        recyclerView.setAdapter(mAdapter);

    }

    class SampleListAdapter extends MultiTypeListAdapter<Sample> {


        @Override
        public int getItemViewType(int position) {
            return ViewType.getType(sList[position]);
        }

        @Override
        public Sample getItem(int viewType, int position) {
            return sList[position];
        }

        @Override
        public BaseItem<?> createItemView(ViewGroup parent, int viewType) {
            return ItemViewFactory.createItem(parent, viewType);
        }

        @Override
        public void unbind(Context context) {

        }

        @Override
        public int getItemCount() {
            return sList.length;
        }
    }
}
