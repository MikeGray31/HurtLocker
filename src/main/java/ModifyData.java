import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ModifyData {

    public static List<String> separateByHashtags(String rawData) {
        Pattern p = Pattern.compile("(\\w|;|:|!|/|\\.|\\*|@|%|\\^)+");
        Matcher m = p.matcher(rawData);
        List<String> results = new ArrayList<>();
        for(int i = 0; m.find(); i++) {
            results.add(m.group());
        }
        return results;
    }

    public static String[] separatePairs(String values){
        Pattern p = Pattern.compile("(\\w|:|\\.|\\/)+");
        Matcher m = p.matcher(values);
        String[] results = new String[4];
        for(int i = 0; m.find(); i++) {
            results[i] = m.group();
        }
        return results;
    }

    public static List<String[]> correctNames(List<String[]> data){
        Pattern p = Pattern.compile("");
        for(String[] sa: data){
            Matcher m = p.matcher(sa[0]);
        }
        return data;
    }


    public static List<Integer> countOccurrences(List<String[]> data){

        return null;
    }
}
