package Strings;

public class StringModule {

    public static void main(String[] args) {
        PatternMatch patternMatch = new PatternMatch();
        patternMatch.kmpAlgorithm("abcfabcdabcfe", "abcf");
    }
}
