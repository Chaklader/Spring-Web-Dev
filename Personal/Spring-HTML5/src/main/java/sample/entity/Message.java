package sample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Chaklader on Nov, 2017
 */
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String person;
    private String text;

    public Message() {
    }

    public Message(String from, String text) {
        this.person = from;
        this.text = text;
    }

    public String getFrom() {
        return person;
    }

    public void setFrom(String from) {
        this.person = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", person='" + person + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
