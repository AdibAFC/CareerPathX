/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package try__;

/**
 *
 * @author Hp
 */
public class DataSearch {

    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isStory() {
        return story;
    }

    public void setStory(boolean story) {
        this.story = story;
    }

    public DataSearch(String text, boolean story) {
        this.text = text;
        this.story = story;
    }

    public DataSearch() {
    }

    private String text;
    private boolean story;
}
