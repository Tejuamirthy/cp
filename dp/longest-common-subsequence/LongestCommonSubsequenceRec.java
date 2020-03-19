public class LongestCommonSubsequenceRec {

    public static void main(String []args){
        String s = "Yellow", t = "Hell!No";
        
        System.out.println(LCSLength(s, t, s.length(), t.length()));
    }
    
    public static int LCSLength(String s, String t, int i, int j) {
        if(i == 0 || j == 0)
            return 0;
        else if(s.charAt(i-1) == t.charAt(j-1))
            return 1 + LCSLength(s, t, i-1, j-1);
        else
            return max(LCSLength(s, t, i-1, j), LCSLength(s, t, i, j-1));
    }
    
    public static int max(int a, int b) {
        if( a >= b)
            return a;
        return b;
    }
    
}
