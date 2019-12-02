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
        String[] array = ModifyData.separateByHashtags(output);
        String[][] ArrayOfArrays = new String[array.length][];
        for(int i =0; i < array.length; i++){
            ArrayOfArrays[i] = ModifyData.separatePairs(array[i]);
        }
        ArrayOfArrays = ModifyData.correctStrings(ArrayOfArrays);
        ArrayOfArrays = ModifyData.correctNames(ArrayOfArrays);




        //for viewing purposes
        for(String[] sa: ArrayOfArrays){
            for(int i = 0; i< sa.length; i++){
                System.out.print(String.format("%22s|||",sa[i]));
            }
            System.out.print("\n");
        }
        System.out.println(ArrayOfArrays.length);

    }
}
