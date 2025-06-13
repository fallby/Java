import static java.lang.Math.abs;

public class CalculateArctangens {
    //           x^(2k + 1)
    // (-1)^x * -----------
    //           (2k + 1)

    public static final double U = Math.ulp(1.0) / (2.0);

    public static double gamma(int n) {
        return n * U / (1.0 - n * U);
    };

    public static Result arctangens(double x, int nMax) {
        double ones = 1.0; //переменная для чередования знаков (-1 и 1)
        double sum = 0.0; //сумма ряда
        double numerator = x; //числитель
        double denominator = 0.0; //знаменатель
        double squaredx = x * x; // х^2

        double predstavleniya_error = 0.0;
        double okryglenie_error = 0.0;
        double[] sumArray = new double[nMax];//Массив для хранения суммы каждого ряда
        double[] fraction = new double[nMax];//Массив для хранения значений каждого члена ряда
        //вычисляет каждый член ряда, записывает в массив и прибавляет к сумме
        for (int k = 0; k < nMax; k++) {
            denominator = 2 * k + 1;
            fraction[k] = ones * numerator / denominator;
            sum += fraction[k];
            sumArray[k] = sum;
            numerator *= squaredx;
            ones = -ones;

            predstavleniya_error += abs(fraction[k]) * gamma(4*k + 2);
        }

        //Оценка погрешности обрыва ряда
        double obryv_ryada_error = numerator * squaredx / (2.0 * (nMax + 1) + 1);
        obryv_ryada_error += Math.ulp(obryv_ryada_error);

        //Оценка погрешности, возникающей из-за округления каждого члена ряда
        for(int i = 0; i < nMax; i++) {
            okryglenie_error +=  Math.abs(fraction[i]) * U;
        }
        okryglenie_error *= gamma(nMax);

        //ошибка суммирования
        double sum_error = gamma(nMax - 1) * okryglenie_error;

        //абсолютная ошибка
        double abs_error = predstavleniya_error + obryv_ryada_error + okryglenie_error + sum_error;

        return new Result(sum, fraction, sumArray, predstavleniya_error, obryv_ryada_error, okryglenie_error, sum_error, abs_error);
    };
}
//U когда одно округление
