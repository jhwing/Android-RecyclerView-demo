package stark.recyclerview.demo.ui.adapter;

/**
 * Created by jihongwen on 16/9/24.
 */

public class Sample {

    public String content;

    public String type;

    public Sample(String content, String type) {
        this.content = content;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "content='" + content + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
