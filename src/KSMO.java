/**
 * Created by Александр on 13.03.2016.
 */

public class KSMO extends SMO{
    protected int k;
    protected int m;
    KSMO(double l, double m,int n) {
        super(l, m, 3);
        this.m = n;
    }

    @Override
    double coutP0() {
        double sum=0;
        for (int i = 0; i <=m ; i++) {
            sum+=Math.pow(ro,i)/fact(i);
        }
        for (int j = 1; j <=k ; j++) {
            sum+=Math.pow(ro,m+j)/(fact(m)*Math.pow(m,j));
        }
        return 1/sum;
    }

    @Override
    double coutMv() {
        double mw = Math.pow(ro,m+1)/(fact(m)*m*Math.pow((1-ro/m),2))*coutP0();
        double mx = 1/mu;
        return mw+mx;
    }
}
