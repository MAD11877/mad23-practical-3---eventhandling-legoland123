package sg.edu.np.mad.madpractical;

public class User {

    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User(){

    }

    public User(String name, String description, int id, boolean followed) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }
}