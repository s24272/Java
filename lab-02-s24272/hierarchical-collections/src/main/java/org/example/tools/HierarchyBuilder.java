package org.example.tools;

import org.example.model.abstraction.IHaveHierarchicalStructure;

import java.util.ArrayList;
import java.util.List;

public class HierarchyBuilder <TItem extends IHaveHierarchicalStructure<TItem>> {

   private List<TItem> listOfItems = new ArrayList<>();
    private TItem root;

    public void setElements(List<TItem> items) {
        listOfItems = items;
    }

    public void buildHierarchy() {
        for (TItem item : listOfItems){
            if(item.getParentId()==null){
                this.root=item;
            }
            for(TItem item2 : listOfItems){
                if(item.getId()==root.getId()){
                    item.setParent(null);
                }else if(item.getParentId()==item2.getId()){
                    item.setParent(item2);
                }
            }

            for(TItem item3 : listOfItems){
                if(item3.getId()==root.getId()){

                }else if(item.getId()==item3.getParentId()){
                    item.getChildren().add(item3);
                }

            }


        }
    }

    public TItem getRootElement() {
        return root;
    }
}
