package.org.example;

public class Util {
    public static String toTitleCase(String str) {

        if (str == null || str.isEmpty()) {
            return str;
        }
      
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
          word = word.toLowerCase();
          String titleWord = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            result.append(titleWord).append(" ");
        }
      return result.toString().trim();
    }
}
