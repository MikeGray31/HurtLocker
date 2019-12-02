import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Item {
    private String name;
    private Integer occurrences;
    private List<String> prices;

    public Item(String name,String price) {
        this.name = name;
        this.occurrences = 1;
        this.prices = new ArrayList<>();
        prices.add(price);
    }

    public void addToPrices(String price){
        this.prices.add(price);
    }

    public void incrementOccurrences() {
        this.occurrences++;
    }

    public Map<String, Integer> findPriceCount() {
        Map<String, Integer> results = new LinkedHashMap<>();
        for (int i = 0; i < this.prices.size(); i++) {
            if (results.containsKey(this.prices.get(i))) {
                results.put(this.prices.get(i), results.get(this.prices.get(i)) + 1);
            }
            else{
                results.put(this.prices.get(i), 1);
            }
        }
        return results;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        String sEquals = String.format("=============          =============\n");
        String sDashes = String.format("-------------          -------------\n");

        if(this.occurrences == 1){ str.append(String.format("%13s%10s%13s\n", "name: " + this.name, "", "seen: " + this.occurrences + " time")); }
        else{ str.append(String.format("%13s%10s%13s\n", "name: " + this.name, "", "seen: " + this.occurrences + " times")); }
        str.append(sEquals);

        for (Map.Entry<String, Integer> k :this.findPriceCount().entrySet()) {
            str.append(String.format("%13s","Price: " + k.getKey()));
            str.append(String.format("%10s",""));
            if(k.getValue() == 1) { str.append(String.format("%13s","seen: " + k.getValue() + " time")); }
            else { str.append(String.format("%13s","seen: " + k.getValue()+ " times")); }
            str.append("\n");
            str.append(sDashes);
        };
        str.append("\n");
        return str.toString();
    }
}
