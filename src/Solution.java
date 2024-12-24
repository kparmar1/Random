class Solution {

    public static int toNumberRepresentation(char AChar) {
        int offset = 'a' - 1;
        return AChar - offset;
    }

    public static boolean isLowerCase(char c) {
        if (Character.isLowerCase(c)) {
            return true;
        }
        return false;
    }

    public static String getSubstitutionCharacters(char c) {
        if(isLowerCase(c)) {
            int num = toNumberRepresentation(c);
            return String.valueOf(num);
        } else {
            return String.valueOf(c);
        }
    }

    public String solution(String S, int K) {
        if (S == null || S.length() == 0) {
            return "";
        } else if (K < 1) {
            return S;
        }

        char[] chars = S.toCharArray();
        int len = chars.length;

        String[] charStrings = new String[len];
        for (int i = 0; i < len; i++) {
            charStrings[i] = String.valueOf(chars[i]);
        }

        int processed = 0;
        int leftPos = 0;
        int rightPos = len - 1;
        boolean left = true;
        for (int i = 0; i < K; i++) {
            if (processed <= len) {
                if (left) {
                    String substitution = getSubstitutionCharacters(chars[leftPos]);
                    charStrings[leftPos] = substitution;
                    left = false;
                    leftPos++;
                } else {
                    String substitution = getSubstitutionCharacters(chars[rightPos]);
                    charStrings[rightPos] = substitution;
                    left = true;
                    rightPos--;
                }
                processed++;
            }  else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : charStrings) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void process(Solution solution, String input, int k) {
        System.out.printf("%s       (%s)%n", input, k);
        System.out.printf("%s\n\n", solution.solution(input, k));
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();

        //System.out.println(Solution.toNumberRepresentation('p'));
        String input = "pbcdtempbcd";
        process(solution,input, 2);

        input = "pbcdtempbcd";
        process(solution,input, 0);

        input = "";
        process(solution,input, 2);

        input = "pbcdtempbcd";
        process(solution,input, 3);

        input = "pbcdtempbcd";
        process(solution,input, 26);

        input = "pbcdtempbcd";
        process(solution,input, 11);

        input = "pBcdtempbcd";
        process(solution,input, 11);

        input = "pb";
        process(solution,input, 2);

        input = "pB";
        process(solution,input, 2);

        input = "pBcdtempbcdpBcdtempbcdpBcdtempbcdpBcdtempbcdpBcdtempbcdpBcdtempbcdpBcdtempbcdpBcdtempbcd";
        process(solution,input, 30);

        input = "aaaaaaaaaaaaaaaaaaaaaaaaa";
        process(solution,input, 10);

        input = "aaaaaaaaaaaaaaaaaaaaaaaaa";
        process(solution,input, 9);

        input = "aaaaaaaaaaaaaaaaaaaaaaaaa";
        process(solution,input, 32);

        input = "abc";
        process(solution,input, 1);

        input = "abc";
        process(solution,input, 26);
    }
}



