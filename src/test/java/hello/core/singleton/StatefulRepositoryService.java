package hello.core.singleton;

public class StatefulRepositoryService {
    public StatefulService statefulService;
    public StatefulRepositoryService(StatefulService statefulService) {
        this.statefulService = statefulService;
    }

    public StatefulService getStatefulService() {
        return statefulService;
    }
}
