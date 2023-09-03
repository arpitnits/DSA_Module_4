package Strings;

public class StringProblems {

    public String reverseWords(String input) {
        int n = input.length();
        String temp = "";
        String ans = "";

        for(int i=0;i<n;i++) {
            char x = input.charAt(i);
            if(x != ' ') {
                temp+= x;
            } else {
                if(ans.equals("")) {
                    ans = temp;
                } else {
                    ans = temp + ' ' + ans;
                }
                temp = "";
            }
        }
        if(temp!="") {
            if(ans.equals("")) {
                ans = temp;
            } else {
                ans = temp + ' ' + ans;
            }
        }
        return ans;
    }
}
