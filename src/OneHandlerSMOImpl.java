/**
 * Created by Михаил on 16.06.2016.
 */
public class OneHandlerSMOImpl extends MultipleHandlerSMO {
    int k; //рамер буффера (очереди)

    public OneHandlerSMOImpl(double l, int m, int k) {
        super(l, m, 1);
        this.k = k;
    }

    @Override
    double getP0() {
        double sum = 0;
        for (int i = 0; i <= channelCount; i++) {
            sum += Math.pow(ro, i) / fact(i);
        }

        for (int i = 1; i <= k; i++) {

            sum += Math.pow(ro, channelCount + i) / (fact(channelCount) * Math.pow(channelCount, i));

        }


        return 1 / sum;
    }

    @Override
    double getMv() { // общее время обработки
        double mw = getQueueLength() / (lamda * (1 - getPfail()));
        double mx = 1 / mu;
        return mw + mx;
    }

    double getQueueLength() {
        double sum = 0;

        for (int i = 1; i < k; i++) {

            sum += getPfail(i) * i;

        }
        return sum;
    }

    double getPfail() {

        return Math.pow(ro, channelCount + k) / (fact(channelCount) * Math.pow(channelCount, k)) * getP0();
    }

    double getPfail(int i) {
        return Math.pow(ro, channelCount + i) / (fact(channelCount) * Math.pow(channelCount, k)) * getP0();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            OneHandlerSMOImpl smo = new OneHandlerSMOImpl(4, 4, i);
            System.out.println(i + "\nMv = " + smo.getMv() + "\nQueueLength = " + smo.getQueueLength() + "\nP0 = " + smo.getP0() + "\nP fail = " + smo.getPfail());
            System.out.println();
        }
    }
}
