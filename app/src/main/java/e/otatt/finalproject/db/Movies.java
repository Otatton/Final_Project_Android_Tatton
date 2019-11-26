package e.otatt.finalproject.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Movies {

    @PrimaryKey(autoGenerate = true)
    private int movie_id;
    private String id, name, description, url, access_key, cost, owned;

    public Movies(String id, String name, String description, String url, String access_key, String cost, String owned) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.access_key = access_key;
        this.cost = cost;
        this.owned = owned;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getOwned() {
        return owned;
    }

    public void setOwned(String owned) {
        this.owned = owned;
    }
}
