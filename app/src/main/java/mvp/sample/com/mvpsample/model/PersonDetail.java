package mvp.sample.com.mvpsample.model;

/**
 * @author amanbansal
 * @version 1.0
 * @since 28/7/17
 */
public class PersonDetail {
    private String name;
    private String Details;
    private int icon;

    public PersonDetail(String name, String details, int icon) {
        this.name = name;
        Details = details;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
