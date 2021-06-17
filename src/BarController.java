import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

abstract public class BarController {
    private ObservableList<Node> workingCollection = FXCollections.observableArrayList(MainClass.bars.getChildren());

    public BarController() {
    }

    public void swap(int elem1, int elem2) {
        Collections.swap(workingCollection, elem1, elem2);
        MainClass.bars.getChildren().setAll(workingCollection);
    }

    public double getNodeHeight(int index) {
        return ((Rectangle) workingCollection.get(index)).getHeight();
    }

    public void shuffle() {
        Collections.shuffle(workingCollection);
        MainClass.bars.getChildren().setAll(workingCollection);
    }

    public void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public ObservableList<Node> getWorkingCollection() {
        return this.workingCollection;
    }

}
