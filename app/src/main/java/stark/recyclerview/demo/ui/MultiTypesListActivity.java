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
import stark.recyclerview.demo.ui.adapter.ActiveItemManager;
import stark.recyclerview.demo.ui.adapter.ItemViewFactory;
import stark.recyclerview.demo.ui.adapter.Sample;
import stark.recyclerview.demo.ui.adapter.ViewType;

/**
 * Created by jihongwen on 16/9/24.
 */

public class MultiTypesListActivity extends BaseSubToolbarActivity {

    Sample[] sList = new Sample[]{
            new Sample("item a", "text"),
            new Sample("item b", "image"),
            new Sample("item c", "video"),
            new Sample("item d", "text"),
            new Sample("item e", "image"),
            new Sample("item f", "video"),
            new Sample("item g", "text"),
            new Sample("item h", "image"),
            new Sample("item i", "video"),
            new Sample("item j", "text"),
            new Sample("item k", "image"),
            new Sample("item l", "video"),
            new Sample("item m", "text"),
            new Sample("item n", "image"),
            new Sample("item o", "video")
    };

    RecyclerView recyclerView;

    SampleListAdapter mAdapter;

    LinearLayoutManager linearLayoutManager;

    ActiveItemManager activeItemManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_types_list);

        sList[0].isPlay = true;
        linearLayoutManager = new LinearLayoutManager(this);
        activeItemManager = new ActiveItemManager();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new SampleListAdapter();
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                activeItemManager.onScrollStateChanged(recyclerView, newState);
            }


            /**
             * 1. up or down
             * 2. first view position last view position
             * 3. current view position percents
             * 4. up current view = first view
             *
             * 5. down current view = last view
             * @param recyclerView
             * @param dx
             * @param dy
             */
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                activeItemManager.onScrolled(recyclerView, dx, dy);
            }
        });
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
