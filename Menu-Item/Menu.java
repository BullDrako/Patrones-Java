package cat.proven.mvcfilms.views;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ProvenSoft
 */
public class Menu {
    private List<MenuItem> items;
    private String title;

    public Menu() {
        items = new ArrayList<>();
    }    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuItem> getItems() {
        return items;
    }
    
    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void show() {
        System.out.format("=========%s===========\n", title);  
        for (int i=0; i<items.size(); i++) {
            System.out.format("[%d] %s\n", i, items.get(i).getText());
        }
    }
}
