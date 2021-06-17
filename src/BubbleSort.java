public class BubbleSort extends BarController {
    private int n = getWorkingCollection().size();
    private int i = 0;
    private int j = 1;

    public BubbleSort() {
        shuffle();
    }

    public boolean sort() {

        while (i < n) {

            while (j < n) {
                double r1Height = getNodeHeight(j - 1);
                double r2Height = getNodeHeight(j);
                if (r1Height > r2Height) {
                    swap(j - 1, j);
                }
                j++;
                return false;
            }
            j = 1;
            i++;

        }
        return true;
    }

}
