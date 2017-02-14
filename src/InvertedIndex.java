import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class InvertedIndex {

    private Map<String, Set<Integer>> dictionary;
    private int wCounter;

    public InvertedIndex(){
        dictionary = new HashMap<>();
        getReader();
    }

    public int getwCounter() {
        return wCounter;
    }

    public String findWord(String word){
        String res = word+ ": " + dictionary.get(word);
        return res;
    }

    public int getSize(){
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
            wCounter++;
            String token = scanner.next().toLowerCase();
            if(dictionary.containsKey(token)){
                dictionary.get(token).add(file_id);
                continue;
            }
            Set<Integer> file_ids = new HashSet<>();
            file_ids.add(file_id);
            dictionary.put(token,file_ids);
        }
    }

    private Map<Integer, String> getFiles(){
        Map<Integer, String > files = new HashMap<>();
        File dir = new File("potter/");
        String[] files_in_dir = dir.list();
        for(int i = 0; i < files_in_dir.length; i++){
            files.put(i,files_in_dir[i]);
        }
        return files;
    }

    private void getReader(){
        Map<Integer, String> files = getFiles();
        for(int i = 0; i < files.size(); i++ ){
            reader("potter/"+files.get(i),i);
        }
    }
}