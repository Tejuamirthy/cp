// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given a non-empty string containing only digits, determine the total number of ways to decode it.

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n >= 1 && s.charAt(0) == '0') {
            return 0;
        } else if(n == 1)
            return 1;
        int s2 = 0, s1 = 1; // s1+s2, at this point is the number of ways for 0th character
        for(int i = 1; i < n; i++) {
            int s22, s11;
            if(s.charAt(i) == '0') {
                s11 = 0;
                if((s.charAt(i-1) == '1' || s.charAt(i-1) == '2'))
                    s22 = s1;
                else
                    s22 = 0;
            } else if((s.charAt(i-1) == '1') || (s.charAt(i-1) == '2' && s.charAt(i) -'0'<= 6)) {
                s11 = s1 + s2;
                s22 = s1;
            } else {
                s11 = s2+s1;
                s22 = 0;
            }
            s1 = s11;
            s2 = s22;
        }
        return s1+s2; // this is the number of ways after nth character
    }
}
