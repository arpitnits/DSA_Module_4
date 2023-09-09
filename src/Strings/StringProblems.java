package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

    public int atoi(String s) {
        int n = s.length();
        int i=0;
        //remove leading whitespaces
        while(i<n && s.charAt(i)==' ') {
            i++;
        }

        boolean neg = false;
        if(i<n && s.charAt(i) == '-' || s.charAt(i)=='+') {
            if(s.charAt(i)== '-')
                neg = true;
            i++;
        }

        int baseAns = 0;
        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9') {
            int val = s.charAt(i) - '0';
            if((baseAns > Integer.MAX_VALUE/10) || (baseAns==Integer.MAX_VALUE/10 && val>7)) {
                if(neg)
                    return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            baseAns = 10*baseAns + val;
            i++;
        }
        if(neg)
            return -baseAns;
        return baseAns;
    }

    public int minSwaps(String str) {
        int n = str.length();
        int open=0, close=0;
        for(int i=0;i<n;i++) {
            char val = str.charAt(i);
            if(val == '[') {
                open++;
            }
            else if(val==']') {
                //pair found
                if(open>0)
                    open--;
                else {
                    close++;
                }

            } else {
                return -1;
            }
        }
        double pairs = open/2.0;
        return (int) Math.ceil(pairs/2.0);
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> firstMap = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();

        int n = s.length();

        for(int i=0;i<n;i++) {
            if( (firstMap.containsKey(s.charAt(i))  && !firstMap.get(s.charAt(i)).equals(t.charAt(i))) ||
                    (reverseMap.containsKey(t.charAt(i))  && !reverseMap.get(t.charAt(i)).equals(s.charAt(i)))) {
                return false;
            } else {
                firstMap.put(s.charAt(i), t.charAt(i));
                reverseMap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
