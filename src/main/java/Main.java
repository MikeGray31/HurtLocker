import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        String[] array = ModifyData.separateByHashtags(output);
        String[][] ArrayOfArrays = new String[array.length][];
        for(int i =0; i < array.length; i++){
            ArrayOfArrays[i] = ModifyData.separatePairs(array[i]);
        }
        ArrayOfArrays = ModifyData.correctStrings(ArrayOfArrays);
        ArrayOfArrays = ModifyData.correctNames(ArrayOfArrays);
        Map<String, Item> items = ModifyData.countItemOccurrences(ArrayOfArrays);

        StringBuilder s = new StringBuilder();
        for(Map.Entry<String, Item> item : items.entrySet()){
            s.append(item.getValue().toString());
        }
        s.append(String.format("%.13s%10s%13s", "Errors", "", "seen: " + ModifyData.countErrors(ArrayOfArrays)) + " times");

        System.out.println(s.toString());
    }
}
