package stark.recyclerview.demo.ui.adapter;

/**
 * Created by jihongwen on 16/9/27.
 */

public class PlayHelper {

    static Sample mSample;

    static int mPosition;

    public static void startPlay(Sample sample, int position) {
        sample.isPlay = true;
        mPosition = position;
    }

    public static void stopPlay() {
        if (mSample != null) {
            mSample.isPlay = false;
        }
        mPosition = -1;
    }
}
