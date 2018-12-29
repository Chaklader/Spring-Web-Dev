package sample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


/**
 * Created by Chaklader on Nov, 2017
 */
@Entity
public class OutputMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String personName;
    private String message;
    private String topic;
    private Date time = new Date();

    public OutputMessage() {
    }

    public OutputMessage(String from, String message, String topic) {
        this.personName = from;
        this.message = message;
        this.topic = topic;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getTime() {
        return time;
    }


    @Override
    public String toString() {
        return "OutputMessage{" +
                "id=" + id +
                ", person='" + personName + '\'' +
                ", message='" + message + '\'' +
                ", topic='" + topic + '\'' +
                ", time=" + time +
                '}';
    }
}
