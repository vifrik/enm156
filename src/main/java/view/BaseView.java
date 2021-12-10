package view;

public abstract class BaseView {
    public BaseView() {
    }

    public void start() {
        setup();
        run();
        cleanup();
    }

    protected abstract void setup();

    protected abstract void run();

    protected abstract void cleanup();
}
