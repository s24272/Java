package org.example.tools;

import org.example.model.abstraction.IHaveHierarchicalStructure;

import java.util.ArrayList;
import java.util.List;

public class Hierarchy <TItem extends IHaveHierarchicalStructure<TItem>>{

    private TItem rootOfList;
    private int index;



    public void setRootElement(TItem rootOfList) {
        this.rootOfList = rootOfList;
    }

    public TItem findElementById(int id) {
        index=id;
        if(rootOfList.getId()==id){
                return rootOfList;
        }
        return searchInChild(rootOfList);

    }

    private TItem searchInChild(TItem item){
        for(TItem elements : item.getChildren()){
            if(elements.getId()==index){
                return elements;
            } else if (!elements.getChildren().isEmpty()){
                TItem result = searchInChild(elements);
                if(result!=null){
                    return result;
                }
            }
        }
        return null;
    }
}
