package stark.recyclerview.demo.ui.adapter;

/**
 * Created by jihongwen on 16/9/24.
 */

public class Sample {

    public int id;

    @Override
    public String toString() {
        return "Sample{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", isPlay=" + isPlay +
                '}';
    }

    public String content;

    public String type;

    public boolean isPlay;


    public Sample(int id, String content, String type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }

    public Sample(String content, String type) {
        this.content = content;
        this.type = type;
    }

}
