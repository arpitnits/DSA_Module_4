package Strings;

public class PatternMatch {

    public void bruteForce(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for(int i=0;i<=n-m;i++) {
            int j;
            for(j=0;j<m;j++) {
                if(pattern.charAt(j) != text.charAt(i+j))
                    break;
            }
            if(j==m) {
                System.out.println("Pattern matched at index: " + i);
            }
        }
    }

    public void rabinKarp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int pHash = 0, tHash = 0;
        int q=256;

        for(int i=0;i<m;i++) {
            pHash+= (pattern.charAt(i) * (int)Math.pow(q, i)) ;
            tHash+= (text.charAt(i) * (int)Math.pow(q, i)) ;
        }

        for(int i=0;i<=n-m;i++) {
            if(pHash == tHash) {
                int j;
                for(j=0;j<m;j++) {
                    if(pattern.charAt(j) != text.charAt(i+j))
                        break;
                }
                if(j==m) {
                    System.out.println("Pattern matched at index: " + i);
                }
            }
            if(i+m<n)
                tHash = ( (tHash - text.charAt(i)) / q ) +
                            (text.charAt(i+m) * (int)Math.pow(q, m-1));
        }
    }

    private void computeLPS(int[] lps, String pattern, int m) {
        lps[0] = 0;
        int i=1, j=0;
        while(i<m) {
            if(pattern.charAt(j) == pattern.charAt(i)) {
                lps[i] = j+1;
                j++;
                i++;
            } else {
                if(j!=0) {
                    j = lps[j-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public void kmpAlgorithm(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] lps = new int[m];
        computeLPS(lps, pattern, m);
        int j=0,i=0;
        //the number of characters remaining in text should be more than pattern
        while((n-i) >= (m-j)) {
            if(pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if(j==m) {
                System.out.println("Pattern matched at index: " + (i-j));
                j=0;
            }

            else if(j>0)
               j = lps[j-1];
            else
                i++;
        }
    }
}
