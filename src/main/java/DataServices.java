import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataServices {

    public static String[] separateByHashtags(String rawData) {
        Pattern p = Pattern.compile("(##)");
        return p.split(rawData);
    }

    public static String[] separatePairs(String values){
        Pattern p = Pattern.compile("(;|!|@|\\^|\\*|%)");
        return p.split(values);
    }

    public static String[][] correctStrings(String[][] data){
        Pattern p = Pattern.compile("(\\w|\\/|\\.)+$");
        for(String[] sa: data){
            for(int i = 0; i < sa.length; i++){
                if(!sa[i].equals(null)) {
                    Matcher m = p.matcher(sa[i]);
                    if(!m.matches()) sa[i] = "";
                    for(int j = 0; m.find(); j++) {
                        sa[i] = m.group();
                    }
                }
            }
        }
        return data;
    }

    public static String[][] correctNames(String[][] data){
        Pattern p = Pattern.compile("^(A-Z)(a-z)+");
        Pattern p2 = Pattern.compile("0");
        for(String[] s : data){
            Matcher m = p.matcher(s[0]);
            if (!m.find() && s[0].length() > 1) s[0] = s[0].substring(0,1).toUpperCase() + s[0].substring(1).toLowerCase();

            Matcher m2 = p2.matcher(s[0]);
            if (m2.find()) s[0] = m2.replaceAll("o");
        }
        return data;
    }


    public static Map<String, Item> countItems(String[][] data){
        Map<String ,Item> results = new LinkedHashMap<>();
        for (int i = 0; i < data.length; i++) {
            if(!(data[i][0].equals("") || data[i][1].equals(""))){
                if(results.containsKey(data[i][0])){
                    results.get(data[i][0]).incrementOccurrences();
                    results.get(data[i][0]).addToPrices(data[i][1]);
                }
                else {
                    results.put(data[i][0], new Item(data[i][0], data[i][1]));
                }
            }
        }
        return results;
    }

    public static Integer countErrors(String[][] data){
        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            if(data[i][0].equals("") || data[i][1].equals("")){
                counter++;
            }
        }
        return counter;
    }
}
