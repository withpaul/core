package hello.core.lifecycle;

public class LifeCycleBean {

    private String url;

    public LifeCycleBean() {
        System.out.println("lifeCycleBean.lifeCycleBean:" + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("lifeCycleBean.connect:" + url);
    }

    public void call() {
        System.out.println("lifeCycleBean.call:" + url);
    }

    public void disconnect() {
        System.out.println("lifeCycleBean.disconnect:" + url);
    }

    public void close() throws Exception {
        System.out.println("LifeCycleBean.close");
        disconnect();
    }

    public void init() throws Exception {
        System.out.println("LifeCycleBean.init");
        connect();
        call();
    }
}
