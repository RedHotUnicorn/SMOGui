import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Александр on 13.03.2016.
 */
public class QueueOfSMOs {

    ArrayList<SMO> queue = new ArrayList<SMO>();

    public void addOneHandlerSMO(double lambda, double mu) {
        SMO smo = new OneHandlerSMO(lambda, mu);
        queue.add(smo);
    }

    public void addMultipleHandlerSMO(int chanelCount, double lambda, double mu) {
        SMO smo = new MultipleHandlerSMO(lambda, mu, chanelCount);
        queue.add(smo);
    }

    public void addLimitedQueueMultipleHandlerSMO(int chanelCount, double lambda, double mu, int queueLimit) {
        SMO smo = new LimitedQueueMultipleHandlerSMO(lambda, mu, chanelCount, queueLimit);
        queue.add(smo);
    }

    public void deleteSMO(int index){
        try {
            queue.remove(index);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Такого элемента не существует");
        }
    }

    public double calculationReactionTimeOffAllQueue() {
        double sum = 0;
        for (int i = 0; i < queue.size(); i++) {
            sum += calculationReactionTimeOffElement(i);
        }
        return sum;
    }

    public double calculationReactionTimeOffElement(int index) {
        return queue.get(index).getMv();
    }

    public static void main(String[] args) throws ParseException {
        /*SMO m1 = new MultipleHandlerSMO(2.0,1.1,2);
        SMO m2 = new OneHandlerSMO(0.8*1.0/3.0,1.0/2.5);
        System.out.println(m1.getP0());

        System.out.println(m1.getMv()+" "+m2.getMv());

        SMO m3 = new MultipleHandlerSMO(0.8*1.0/3.0,1.0/5.0,2);
        SMO m4 = new OneHandlerSMO(0.8*1.0/3.0,1.0/2.5);

        System.out.println(m3.getMv()+m4.getMv());

        SMO m5 = new MultipleHandlerSMO(1.0/3.0,1.0/5.0,3);
        SMO m6 = new OneHandlerSMO(0.8*1.0/3.0,1.0/2.5);

        System.out.println(m5.getMv()+m6.getMv());*/
        QueueOfSMOs q = new QueueOfSMOs();
        q.addOneHandlerSMO(0.8*1.0/3.0,1.0/2.5);
        q.addMultipleHandlerSMO(2,2.0,1.1);
        q.addMultipleHandlerSMO(2,0.8*1.0/3.0,1.0/5.0);
        q.addOneHandlerSMO(0.8*1.0/3.0,1.0/2.5);
        q.addMultipleHandlerSMO(3,1.0/3.0,1.0/5.0);
        q.addOneHandlerSMO(0.8*1.0/3.0,1.0/2.5);
        System.out.println(q.calculationReactionTimeOffAllQueue());
        q.deleteSMO(68);
        double d1=Double.parseDouble("2.68");
        double d2;
        try {
             d2 = Double.parseDouble("2,69");  //метод который парсит запятую вместо точки как разделитьель
        }catch(NumberFormatException e) {
            DecimalFormat df = new DecimalFormat();
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator(' ');
            df.setDecimalFormatSymbols(symbols);
            d2 = df.parse("2,69").doubleValue();
        }
        System.out.println(d1+" "+d2);
    }

}
