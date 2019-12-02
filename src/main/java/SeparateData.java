import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparateData {

    public static List<String> separateByHashtags(String rawData) {
        Pattern p = Pattern.compile("(##)");
        Matcher m = p.matcher(rawData);
        List<String> results = new ArrayList<>();
        int start = 0;
        for(int i = 0; m.find(); i++) {
            int end = m.start();
            results.add(rawData.substring(start, end));
            start = m.end();
        }
        return results;
    }

    public static String[] separatePairs(String values){
        Pattern p = Pattern.compile("[;@^*%!]");
        Matcher m = p.matcher(values);
        String[] results = new String[4];
        int start = 0;
        for(int i = 0; m.find(); i++) {
            int end = m.start();
            results[i] = values.substring(start, end);
            start = m.end();
        }
        results[3] = values.substring(start);
        return results;
    }
}
