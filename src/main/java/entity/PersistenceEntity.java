package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PersistenceEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String publicKey;
    private String googleMail;
    private String facebookMail;
    private String blAccMail;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getGoogleMail() {
        return googleMail;
    }

    public void setGoogleMail(String googleMail) {
        this.googleMail = googleMail;
    }

    public String getFacebookMail() {
        return facebookMail;
    }

    public void setFacebookMail(String facebookMail) {
        this.facebookMail = facebookMail;
    }

    public String getBlAccMail() {
        return blAccMail;
    }

    public void setBlAccMail(String blAccMail) {
        this.blAccMail = blAccMail;
    }
}
