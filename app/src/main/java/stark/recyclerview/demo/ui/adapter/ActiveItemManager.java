package stark.recyclerview.demo.ui.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

import stark.android.appbase.widget.recyclerview.BaseItem;

/**
 * Created by jihongwen on 16/9/26.
 */

public class ActiveItemManager {

    public enum ScrollDirection {
        UP, DOWN, IDLE
    }

    ScrollDirection scrollDirection;

    int mNewState = RecyclerView.SCROLL_STATE_IDLE;
    int firstVisiblePosition;
    int lastVisiblePosition;

    SparseArray<View> activeView = new SparseArray<>();

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (dy > 0) {
            scrollDirection = ScrollDirection.UP;
        } else if ((dy < 0)) {
            scrollDirection = ScrollDirection.DOWN;
        } else {
            scrollDirection = ScrollDirection.IDLE;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        firstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition();
        lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
        int visibleItemCount = lastVisiblePosition - firstVisiblePosition + 1;
        int state = recyclerView.getScrollState();
        switch (state) {
            case RecyclerView.SCROLL_STATE_IDLE:
                addActiveView(recyclerView, visibleItemCount);
                checkActive();
                Log.d("jihongwen", "onScrolled SCROLL_STATE_IDLE");
                break;
            case RecyclerView.SCROLL_STATE_DRAGGING:
            case RecyclerView.SCROLL_STATE_SETTLING:
                break;
        }
    }

    private void checkActive() {
        for (int i = 0; i < activeView.size(); i++) {
            View view = activeView.get(i);
            BaseItem baseItem = (BaseItem) view.getTag();
            int percent = baseItem.getVisibilityPercents(view);
            if (percent > 50) {
                baseItem.onActive(view);
            } else {
                baseItem.onDeactivate(view);
            }
        }
    }

    private void addActiveView(RecyclerView recyclerView, int visibleItemCount) {
        for (int i = 0; i < visibleItemCount; i++) {
            View view = recyclerView.getChildAt(i);
            activeView.append(i, view);
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        firstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition();
        lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
        int visibleItemCount = lastVisiblePosition - firstVisiblePosition + 1;

        mNewState = newState;
        switch (mNewState) {
            case RecyclerView.SCROLL_STATE_IDLE:
                scrollDirection = ScrollDirection.IDLE;
                addActiveView(recyclerView, visibleItemCount);
                checkActive();
                Log.d("jihongwen", "onScrollStateChanged SCROLL_STATE_IDLE");
                break;
            case RecyclerView.SCROLL_STATE_DRAGGING:
                Log.d("jihongwen", "mNewState: SCROLL_STATE_DRAGGING");
                break;
            case RecyclerView.SCROLL_STATE_SETTLING:
                Log.d("jihongwen", "mNewState: SCROLL_STATE_SETTLING");
                break;
        }
    }
}
