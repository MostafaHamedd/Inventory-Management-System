package comp3350.ims.objects;

import java.util.List;

public class Item{

    private String id;

    public Item(){} //Base constructor

    public Item(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setId(String i){
        this.id = i;
    }


}
