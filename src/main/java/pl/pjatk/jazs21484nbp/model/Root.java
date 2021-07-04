package pl.pjatk.jazs21484nbp.model;

import java.util.List;

public class Root {

    private List<Price> prices;

    public Root(List<Price> prices) {
        this.prices = prices;
    }

    public Root() {
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
