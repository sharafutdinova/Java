package practice_7.photo_editor;

import java.util.Stack;

public class PhotoEditor {
    private Stack<String> actions;

    public PhotoEditor() {
        actions = new Stack<>();
    }

    public void addAction(String action) {
        actions.push(action);
    }

    public void cancelAction() {
        actions.pop();
    }

    public void printActions() {
        actions.forEach(System.out::println);
    }
}
