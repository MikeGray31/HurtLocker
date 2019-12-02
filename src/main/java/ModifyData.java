import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModifyData {

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


    public static List<Item> countItemOccurrences(String[][] data){
        List<Item> results = new ArrayList<>();
//        for (String[] sa: data) {
//            if(results.contains()){
//
//            }
//            Item i = new Item(sa[0], sa[1], sa[3]);
//        }
        return results;
    }
}
