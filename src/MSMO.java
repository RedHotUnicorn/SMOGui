/**
 * Created by Александр on 13.03.2016.
 */

public class MSMO extends SMO{
    protected int m;
    MSMO(double l, double m,int n) {
        super(l, m, 2);
        this.m = n;
    }

    @Override
    double coutP0() {
        double sum=0;
        for (int i = 0; i <=m ; i++) {
            sum+=Math.pow(ro,i)/fact(i);
        }
        sum+=Math.pow(ro,m+1)/(fact(m)*(m-ro));

        return 1/sum;
    }

    @Override
    double coutMv() {

        double mw = Math.pow(ro,m+1)/(fact(m)*m*Math.pow((1-ro/m),2))*coutP0()/lamda;
        double mx = 1/mu;
        return mw+mx;
    }
}
