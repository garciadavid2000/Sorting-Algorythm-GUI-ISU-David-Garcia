public class SelectionSort extends BarController {
    public SelectionSort() {
        shuffle();
    }

    int j = 0;

    public boolean sort() {

        while (j < getWorkingCollection().size() - 1) {
            int index = j;
            for (int k = j + 1; k < getWorkingCollection().size(); k++) {
                if (getNodeHeight(k) < getNodeHeight(index)) {
                    index = k;
                }
            }
            swap(j, index);
            j++;
            return false;
        }
        return true;

    }

}
