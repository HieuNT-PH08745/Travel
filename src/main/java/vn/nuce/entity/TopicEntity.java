package vn.nuce.entity;

import javax.persistence.*;

@Entity
@Table(name = "topic")
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topic_ID;

    @Column(name = "topic_Name")
    private String topic_Name;

    public Long getTopic_ID() {
        return topic_ID;
    }

    public void setTopic_ID(Long topic_ID) {
        this.topic_ID = topic_ID;
    }

    public String getTopic_Name() {
        return topic_Name;
    }

    public void setTopic_Name(String topic_Name) {
        this.topic_Name = topic_Name;
    }
}
