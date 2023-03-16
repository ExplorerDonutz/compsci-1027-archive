package lab8;

public class Person implements Comparable<Person> {

    /* Attribute declarations */
    private String name;
    private String city;
    private String email;

    /**
     * Constructor initializes the person's name and email address
     */
    public Person(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
    }

    /**
     * toString to display the person's info in a clean format
     * return String of the person's info
     */
    public String toString() {
        String s = String.format("%10s\t\t%30s\t\t%10s", name, email, city);
        return s;
    }

    /**
     * compareTo determines the order of the contacts
     */
    public int compareTo(Person other) {
        switch (ContactList.sortBy) {
            case 'n':
                return compareByName(other);
            case 'e':
                return compareByEmail(other);
            case 'c':
                return compareByCity(other);
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    private int compareByName(Person other) {
        int lex = this.getName().compareTo(other.getName());

        if (lex == 0)
            return 0;
        else if (lex > 0)
            return 1;
        return -1;
    }

    private int compareByEmail(Person other) {
        int lex = this.getEmail().compareTo(other.getEmail());

        if (lex == 0)
            return 0;
        else if (lex > 0)
            return 1;
        return -1;
    }

    private int compareByCity(Person other) {
        int lex = this.getCity().compareTo(other.getCity());

        if (lex == 0)
            return 0;
        else if (lex > 0)
            return 1;
        return -1;
    }
}