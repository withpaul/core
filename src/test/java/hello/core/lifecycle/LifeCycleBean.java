package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifeCycleBean implements InitializingBean, DisposableBean {

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

    @Override
    public void destroy() throws Exception {
        System.out.println("LifeCycleBean.destroy");
        disconnect();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifeCycleBean.afterPropertiesSet");
        connect();
        call();
    }
}
