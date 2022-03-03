import java.util.LinkedList;
import java.util.regex.*;

public class QueryHandler {
    private LinkedList<Object[]> regCommand = new LinkedList<Object[]>();

    private Pattern name = Pattern.compile("(?i)(\bname\b)");
    private Pattern homePhone = Pattern.compile("(?i)(\bphone\b)");
    private Pattern colaPhone = Pattern.compile("(?i)(\bphone\b)");
    private Pattern homeAddress = Pattern.compile("(?i)(\baddress\b)");
    private Pattern colaAddress = Pattern.compile("(?i)(\baddress\b)");
    private Pattern region = Pattern.compile("(?i)(\bregion\b)");

    private String nameCommand = "\"Contact Information:name\"";
    private String homePhoneCommand = "\"Contact Information:home phone\"";
    private String colaPhoneCommand = "\"Contact Information:columbia phone\"";
    private String homeAddressCommand = "\"Contact Information:home address\"";
    private String colaAddressCommand = "\"Contact Information:columbia address\"";
    private String regionCommand = "\"Contact Information:region\"";

    private Object[] namePair = {name, nameCommand};
    private Object[] homePhonePair = {homePhone, homePhoneCommand};
    private Object[] colaPhonePair = {colaPhone, colaPhoneCommand};
    private Object[] homeAddressPair = {homeAddress, homeAddressCommand};
    private Object[] colaAddressPair = {colaAddress, colaAddressCommand};
    private Object[] regionPair = {region, regionCommand};


    public QueryHandler() {
        this.regCommand.add(namePair);
        this.regCommand.add(homePhonePair);
        this.regCommand.add(colaPhonePair);
        this.regCommand.add(homeAddressPair);
        this.regCommand.add(colaAddressPair);
        this.regCommand.add(regionPair);

    }

    /*
    private String run(String s) {
        
    }

    private String compareToAll() {
        for(int i=0; i<regCommand.size(); i++) {
            if (matchChecker((Pattern)regCommand.get(i)[0], s)) {
                return (String)regCommand.get(i)[1];
            } else {
                return ""
            }
        }
    }
*/

    private boolean matchChecker(Pattern p, String s) {
        if (p.matcher(s).matches()) {
            return true;
        } else {
            return false;
        }
    }

}