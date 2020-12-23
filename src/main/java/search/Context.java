package search;

import java.util.List;

public class Context {

    private Strategy strategy;

    public static Context createStrategy(String strategyName) {
        Context context = new Context();
        switch (strategyName) {
            case "ALL":
                context.setStrategy(new AllStrategy());
                break;
            case "ANY":
                context.setStrategy(new AnyStrategy());
                break;
            case "NONE":
                context.setStrategy(new NoneStrategy());
                break;
            default:
                throw new IllegalArgumentException();
        }
        return context;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<String> invoke(List<String> allPersons, List<String> queries) {
        strategy.setAllPersons(allPersons);
        strategy.setQueries(queries);
        strategy.buildIndecies();
        return strategy.execute();
    }
}
