import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private Integer occurrences;
    private List<String> expDates;
    private List<String> prices;

    public Item(String name,String price, String expDate) {
        this.name = name;
        this.occurrences = 1;
        this.prices = new ArrayList<>();
        prices.add(price);
        this.expDates = new ArrayList<>();
        expDates.add(expDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
