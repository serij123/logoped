package com.ssmelnikov.demo.entity;

import org.bson.Document;
import org.springframework.data.annotation.Id;



import java.util.Date;
import java.util.List;

/**
 * Created by Melnikov_S on 22.09.2017.
 */
@org.springframework.data.mongodb.core.mapping.Document
public class Chat {
    @Id
    private String id;

    private String createdBy;
    private String name;
    private Date createDate;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
