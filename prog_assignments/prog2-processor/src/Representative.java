public class Representative {
    // Type I1
    private String name;
    private String region;
    private String homeAddress;
    private String colaAddress;
    private String homePhone;
    private String colaPhone;

    // Type I2
    // Type I3
    // Type I4
    // Type I5
    // Type I6

    // Constructor
    public Representative(String name, String region, String homeAddy, String colaAddy, String homeP, String colaP) {
        this.name = name;
        this.region = region;
        this.homeAddress = homeAddy;
        this.colaAddress = colaAddy;
        this.homePhone = homeP;
        this.colaPhone = colaP;
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public String getRegion() {
        return this.region;
    }
    public String getHomeAddress() {
        return this.homeAddress;
    }
    public String getColaAddress() {
        return this.colaAddress;
    }
    public String getHomePhone() {
        return this.homePhone;
    }
    public String getColaPhone() {
        return this.colaPhone;
    }

    
}
