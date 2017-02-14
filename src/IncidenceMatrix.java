import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class IncidenceMatrix {
    private Map<String, byte[]> dictionary;
    private List<String> files;
    private int wCounter;

    public IncidenceMatrix(){
        dictionary = new HashMap<>();
        files = getFiles();
        getReader();
    }

    public int getScannedWordsCount() {
        return wCounter;
    }

    public Map<String, byte[]> getDictionary() {
        return dictionary;
    }

    public String findWord(String word){
        String res = word+ ": ";
        for(int i = 0; i < files.size(); i++){
            res+= dictionary.get(word)[i];
        }
        return res;
    }

    public int getDictionarySize(){
        return dictionary.size();
    }


    private void reader(String file_path, int file_id){
        File file = new File(file_path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter("[^A-Za-z]+");
        while(scanner.hasNext()){
            String token = scanner.next().toLowerCase();
            if(!dictionary.containsKey(token)){
                byte[] status = new byte[files.size()];
                status[file_id] = 0x01;
                dictionary.put(token,status);
            }
            dictionary.get(token)[file_id] = 0x01;
            wCounter++;
        }
    }
    private List<String> getFiles(){
        List<String> files = new ArrayList<>();
        File dir = new File("potter/");
        String[] files_in_dir = dir.list();
        for(String i : files_in_dir){
            files.add(i);
        }
        return files;
    }

    private void getReader(){
        for(int i = 0; i < files.size(); i++ ){
            reader("potter/"+files.get(i),i);
        }
    }
}