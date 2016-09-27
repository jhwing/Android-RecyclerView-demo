package stark.recyclerview.demo.ui.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
        Log.d("jihongwen", "firstVisiblePosition:" + firstVisiblePosition);
        Log.d("jihongwen", "lastVisiblePosition:" + lastVisiblePosition);
        Log.d("jihongwen", "visibleItemCount:" + visibleItemCount);

        int state = recyclerView.getScrollState();
        switch (state) {
            case RecyclerView.SCROLL_STATE_IDLE:
            case RecyclerView.SCROLL_STATE_DRAGGING:
            case RecyclerView.SCROLL_STATE_SETTLING:
                for (int i = 0; i < visibleItemCount; i++) {
                    View view = recyclerView.getChildAt(i);
                    BaseItem baseItem = (BaseItem) view.getTag();
                    if (baseItem.getViewType() == ViewType.VIDEO) {
                        Log.d("jihongwen", "onScrolled video item " + i);
                        int percents = baseItem.getVisibilityPercents(view);
                        if (percents > 50) {
                            baseItem.onActive(view, i);
                        } else {
                            baseItem.onDeactivate(view, i);
                        }
                    } else {
                        Log.d("jihongwen", "onScrolled ViewType not video " + i);
                    }
                }
                Log.d("jihongwen", "onScrolled SCROLL_STATE_IDLE");
                break;
//            case RecyclerView.SCROLL_STATE_DRAGGING:
//            case RecyclerView.SCROLL_STATE_SETTLING:

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
                for (int i = 0; i < visibleItemCount; i++) {
                    View view = recyclerView.getChildAt(i);
                    if (view == null) {
                        Log.d("jihongwen", "onScrolled view is null " + i);
                        continue;
                    }
                    BaseItem baseItem = (BaseItem) view.getTag();
                    if (baseItem.getViewType() == ViewType.VIDEO) {
                        Log.d("jihongwen", "onScrollStateChanged video item " + i);
                        int percents = baseItem.getVisibilityPercents(view);
                        if (percents > 50) {
                            baseItem.onActive(view, i);
                        } else {
                            baseItem.onDeactivate(view, i);
                        }
                    } else {
                        Log.d("jihongwen", "onScrolled ViewType not video " + i);
                    }
                }
                Log.d("jihongwen", "onScrollStateChanged SCROLL_STATE_IDLE");

                switch (scrollDirection) {
                    case UP:
                        // 底部视频显示超过一半
                        Log.d("jihongwen", "底部视频显示超过一半 up");
                        break;
                    case DOWN:
                        // 顶部视频显示超过一半
                        Log.d("jihongwen", "顶部视频显示超过一半 down");
                        break;
                }
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
