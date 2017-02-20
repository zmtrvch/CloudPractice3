public class Tester {

    public static void main(String[] args) {
    	System.out.println("Incidence Matrix");
        IncidenceMatrix matrix = new IncidenceMatrix();
        System.out.println("Number od words: " + matrix.getScannedWordsCount());
        System.out.println("Number od wordsin dictionary: " + matrix.getDictionarySize());
        System.out.println(matrix.findWord("daisy"));
        System.out.println(matrix.findWord("harry"));
        //"smth " was my conflict
        System.out.println(matrix.findWord("tom"));
        System.out.println(matrix.findWord("severus"));
        
        System.out.println("\nInverted Index");
        InvertedIndex index = new InvertedIndex();
        System.out.println("Number od words: " + index.getwCounter());
        System.out.println("Number od wordsin dictionary: " + index.getSize());
        //changed
        System.out.println(index.findWord("it probably may  cause a conflict"));
        System.out.println(index.findWord("snape"));
        System.out.println(index.findWord("hello"));
        

      
    }
}