import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.Map;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        String[] array = DataServices.separateByHashtags(output);
        String[][] ArrayOfArrays = new String[array.length][];
        for(int i =0; i < array.length; i++){
            ArrayOfArrays[i] = DataServices.separatePairs(array[i]);
        }
        ArrayOfArrays = DataServices.correctStrings(ArrayOfArrays);
        ArrayOfArrays = DataServices.correctNames(ArrayOfArrays);
        Map<String, Item> items = DataServices.countItemOccurrences(ArrayOfArrays);

        StringBuilder s = new StringBuilder();
        for(Map.Entry<String, Item> item : items.entrySet()){
            s.append(item.getValue().toString());
        }
        s.append(String.format("%13s%10s%s", "Errors", "", "seen: " + DataServices.countErrors(ArrayOfArrays)) + " times");

        System.out.println(s.toString());
    }
}
