/**
 * Created by Александр on 13.03.2016.
 */
import java.lang.Math;

public abstract class SMO {
    protected double lamda;
    protected double mu;
    protected double ro;
    protected double mv;
    protected int type;
    SMO(double l, double m,int t){
        lamda = l;
        mu=m;
        type = t;
        ro=l/m;
    }

    abstract double coutP0();
    abstract double coutMv();
    public int fact(int num) {
        return (num == 0) ? 1 : num * fact(num - 1);
    }
}
