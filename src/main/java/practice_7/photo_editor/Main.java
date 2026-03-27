package practice_7.photo_editor;

public class Main {
    public static void main(String[] args) {
        PhotoEditor photoEditor = new PhotoEditor();
        photoEditor.addAction("Go");
        photoEditor.addAction("Stop");
        photoEditor.addAction("Pause");
        photoEditor.addAction("Delete");
        photoEditor.printActions();
        photoEditor.cancelAction();
        photoEditor.printActions();
    }
}
