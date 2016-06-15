/**
 * Created by Александр on 13.03.2016.
 */

public class MultipleHandlerSMO extends SMO {
    protected int channelCount;

    MultipleHandlerSMO(double l, double channelCount, int n) {
        super(l, channelCount, 2);
        this.channelCount = n;
    }

    @Override
    double getP0() {
        double sum=0;
        for (int i = 0; i <= channelCount; i++) {
            sum+=Math.pow(ro,i)/fact(i);
        }
        sum+=Math.pow(ro, channelCount +1)/(fact(channelCount)*(channelCount -ro));

        return 1/sum;
    }

    @Override
    double getMv() {

        double mw = Math.pow(ro, channelCount +1)/(fact(channelCount)* channelCount *Math.pow((1-ro/ channelCount),2))* getP0()/lamda;
        double mx = 1/mu;
        return mw+mx;
    }
}
