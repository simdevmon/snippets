package com.simdevmon.redeployment;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author simdevmon
 */
@Entity
@NamedQueries(
        {
            @NamedQuery(name = ExampleEntity.ALL, query = "SELECT n FROM ExampleEntity n")
        })
public class ExampleEntity implements Serializable
{

    private static final long serialVersionUID = -8397652567602961323L;

    public static final String ALL = "ExampleEntity.all";
    @Id
    private Long exampleId;

    private String name;

    public Long getExampleId()
    {
        return exampleId;
    }

    public void setExampleId(Long exampleId)
    {
        this.exampleId = exampleId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
