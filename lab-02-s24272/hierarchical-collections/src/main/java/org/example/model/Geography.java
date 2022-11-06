package org.example.model;

import org.example.model.abstraction.IHaveHierarchicalStructure;

import java.util.ArrayList;
import java.util.List;

public class Geography implements IHaveHierarchicalStructure<Geography> {
    private int id;
    private String name;
    private String type;
    private String code;
    private Integer parentId;
    private Geography parent;



    private List<Geography> listOfChildren = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    @Override
    public void setParent(Geography geography) {
        this.parent = geography;
    }

    @Override
    public List getChildren() {
        return listOfChildren;
    }

    @Override
    public Geography getParent() {
        return parent;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Integer getParentId() {
        return parentId;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

}
