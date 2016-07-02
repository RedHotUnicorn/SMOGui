/**
 * Created by Александр on 13.03.2016.
 */

public class MultipleHandlerSMO extends SMO {
    protected int channelCount;

    protected double sumOfRoDivideToIFact;


    MultipleHandlerSMO(double lambda, double mu, int chanelCount) {
        super(lambda, mu);
        this.channelCount = chanelCount;
        this.type = typesOfSMO.MultipleHandler;
        this.calculateCharacteristicOfSMO();

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

    double getProbablyOfState(int stateNumber) {
        return  Math.pow(ro, stateNumber)*p0/
                (fact(channelCount)* (stateNumber <=channelCount? 1 :Math.pow(channelCount, stateNumber -channelCount)  ));
    }


}
