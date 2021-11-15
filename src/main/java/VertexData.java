public class VertexData {
    private String name;
    private int time;
    private boolean isSource;

    public VertexData(String name, int time, boolean isSource) {
        this.name = name;
        this.time = time;
        this.isSource = isSource;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public boolean getIsSource() {
        return isSource;
    }

    public String toString() {
        return name + "-" + time;
    }
}
