package pack1;

public class ClassOne {
    public static void main(String[] args) {
        System.out.println(reverseWords("bitcoin take  over the world  maybe who knows perhaps"));
    }
    public static String reverseWords(final String original)
    {
        String result = "";
        StringBuilder reverse = new StringBuilder(original);
        reverse.reverse();
        int start = reverse.length() - 1;
        int end = reverse.length();
        // spahrep swonk ohw ebyam  dlrow eht revo  ekat nioctib
        for (int i = start; i > 0; i--){
            for (int j = start; j > 0; j--) {
                if (reverse.charAt(j) == ' ') {
                    start = j + 1;
                    result += " ";
                }
            }
            result += reverse.substring(start, end);
            System.out.println(result
            );
            end = start;
        }
        result += reverse.substring(0, end);

        return result;

    }

}
