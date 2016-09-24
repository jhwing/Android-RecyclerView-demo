package stark.recyclerview.demo.ui.adapter;

/**
 * Created by jihongwen on 16/9/24.
 */

public class ViewType {

    public static final int DEFAULT = 0;
    public static final int TEXT = 1;
    public static final int IMAGE = 2;
    public static final int VIDEO = 3;

    public static int getType(Sample sample) {
        if ("text".equals(sample.type)) {
            return TEXT;
        } else if ("image".equals(sample.type)) {
            return IMAGE;
        } else if ("video".equals(sample.type)) {
            return VIDEO;
        }
        return DEFAULT;
    }
}
