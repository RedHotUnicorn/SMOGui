/**
 * Created by Александр on 13.03.2016.
 */

public class MultipleHandlerSMO extends SMO {
    protected int channelCount;


    protected double sumOfRoDivideToIFact;
    MultipleHandlerSMO(double lambda, double mu, int chanelCount) {
        super(lambda, mu, 2);
        this.channelCount = chanelCount;
    }

    public void setSumOfRoDivideToIFact() {
        this.sumOfRoDivideToIFact =0;
        for (int i = 0; i <= channelCount; i++) {
            this.sumOfRoDivideToIFact +=Math.pow(ro,i)/fact(i);
        }
    }

    public double getSumOfRoDivideToIFact() {
        return sumOfRoDivideToIFact;
    }

    void setP0() {
        double sum= getSumOfRoDivideToIFact();

        sum+=Math.pow(ro, channelCount +1)/(fact(channelCount)*(channelCount -ro));

        p0= 1/sum;
    }

    @Override
    void setMv() {

        mw = Math.pow(ro, channelCount +1)/(fact(channelCount)* channelCount *Math.pow((1-ro/ channelCount),2))* getP0()/lamda;
        mx = 1/mu;
        mv= mw+mx;
    }

    double getProb(int pNubmer) {
        return  Math.pow(ro,pNubmer)*p0/
                (fact(channelCount)* (pNubmer<=channelCount? 1 :Math.pow(channelCount,pNubmer-channelCount)  ));
    }


}