public class PrintFirstLetter {
    public static void main(String args[]) {
        String str = getFirstLetterOfAllWords(" this is a test case ");
        /*  
            Given a string containing words separated by arbitrary number of spaces. 
            Write a function that returns a string consisting of the first letter of each word. 
        */
        System.out.println(str);
    }

    static String getFirstLetterOfAllWords(String str) {
        
        int n = str.length(), i = 0;
        while(i < n && str.charAt(i) == ' ')
            i++;
        
        StringBuilder result = new StringBuilder("");

        if(str.charAt(i) != ' ')
            result.append(str.charAt(i));

        while(i < n ) {
            if(str.charAt(i) == ' ') {
                while(i < n && str.charAt(i) == ' ')
                    i++;
                if( i < n)
                    result.append(str.charAt(i));
            }
            i++;
        }

        return result.toString();
    }

}