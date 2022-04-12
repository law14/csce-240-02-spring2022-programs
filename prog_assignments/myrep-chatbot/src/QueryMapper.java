public class QueryMapper {
    private String[] knownQueries = {
        "quit",
        "tell me about the rep",
        "Where does the rep live",
        "how do I contact my rep",
        "what committees is my rep on",
        "tell me everything"
    };
    private int queryNumber = -1;
    private String query = "";

    public QueryMapper(String in){
        /*
        String[] t1 = {"job", "tom", "bob", "ham", "james", "tim"};
        String[] t2 = {"tim", "jam", "ham", "tom", "bob", "james"};
        double test = wordMatcher(t1, t2);
        System.out.println(test);

        System.out.println("\n\n\n");
        String userUtterance = "what  is my  on";
        System.out.println(test2);
        */
        int num = determineQuery(in, knownQueries);
        setQueryNumber(num);
        setQuery(this.queryNumber);
    }

    private void setQuery(int n) {
        if (n==2) {
            query = "prog2processor -t \"Contact Information:home address\"";
        } else if (n==3) {
            query = "prog2processor -t \"Contact Information:columbia phone\"";
        } else if (n==5) {
            query = "prog2processor -t \"Contact Information\"";
        }
    }
    public String getQuery() {
        return this.query;
    }
    private void setQueryNumber(int n) {
        if (n>-1) {
            queryNumber = n;
        } else {
            queryNumber = -1;
        }
    }

    public int determineQuery(String query, String[] queryArray) {
        double percentMatch = 0;
        int queryNum = -1;

        String[] userQueryWordArray = splitStringToWords(query);
        for (int i = 0; i<queryArray.length; i++) {
            String[] possibleQuery = splitStringToWords(queryArray[i]);
            double currentPercentMatch = wordMatcher(userQueryWordArray, possibleQuery);
            // System.out.println(currentPercentMatch);
            if ((currentPercentMatch > percentMatch) && currentPercentMatch > 0.7) {
                percentMatch = currentPercentMatch;
                queryNum = i;
            }
        }
        return queryNum;

    }
    /**
     * takes the given string and splits it into words
     * @param str A string of words delimited by a whitespace
     * @return A string arry of words from the str parameter
     */
    private String[] splitStringToWords(String str) {
        String[] words = str.split(" ");
        return words;
    }
    /**
     * matches p1 to p2 and returns a percentage match
     * @param p1 the first string array consisting of words
     * @param p2 the second string array consisting of words
     * @return a double as percent of words matched from p1 to p2
     */
    private double wordMatcher(String[] p1, String[] p2) {
        String[] words1 = p1;
        String[] words2 = p2;
        int wordsMatched = 0;
        for (int i=0; i<words2.length; i++) {
            for (int j=0; j<words1.length; j++) {
                if (words2[i].equalsIgnoreCase(words1[j])) {
                    wordsMatched++;
                }
            }
        }
        return (double) wordsMatched / words2.length;
    }
}
