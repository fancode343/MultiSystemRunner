import java.io.File;
import java.util.*;

public class MSR {
    public static void main(String[] args) {
        String folder = "Systems";
        String[] files = getSystems.listFiles(folder);
        System.out.println(Arrays.toString(files));
        
    }
    public static class getSystems {
        public static String[] listFiles(String path) {
            File dir = new File(path);
            File[] listOfFiles = dir.listFiles();
            if (listOfFiles == null) {
                return new String[0];
            }
            List<String> result = new ArrayList<>();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    if(path.equals("Systems")) {
                        result.add(file.getName());
                    }else{
                        result.add(path.substring(8)+"/"+file.getName());
                    }
                } else if (file.isDirectory()) {
                    String[] subFiles = listFiles(path + "/" + file.getName());
                    result.addAll(Arrays.asList(subFiles));
                }
            }
            return result.toArray(new String[0]);
        }
    }
}
