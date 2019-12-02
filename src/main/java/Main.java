import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        List<String> list = ModifyData.separateByHashtags(output);
        List<String[]>listOfArrays = new ArrayList<>();
        listOfArrays = ModifyData.correctNames(listOfArrays);
        for(String s : list){ listOfArrays.add(ModifyData.separatePairs(s)); }

        System.out.println(list);

        //for viewing purposes
        for(String[] sa: listOfArrays){
            for(int i = 0; i< sa.length; i++){
                System.out.print(String.format("%22s|||",sa[i]));
            }
            System.out.print("\n");
        }
        System.out.println(listOfArrays.size());

    }
}
