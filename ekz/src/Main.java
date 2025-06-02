import java.math.BigDecimal;
import static java.lang.Math.*;
import static java.lang.Math.abs;
import java.util.Arrays;

//класс Result для дальнейшего удобного вывода результата работы функции arctangens
class Result {
    public double sum;
    public double[] fraction;
    public double[] sumArray;
    public double predstavleniya_error;
    public double obryv_ryada_error;
    public double okryglenie_error;

    public Result(double sum, double[] fraction, double[] sumArray, double predstavleniya_error, double first_error, double second_error) {
        this.sum = sum;
        this.fraction = fraction;
        this.sumArray = sumArray;
        this.predstavleniya_error = predstavleniya_error;
        this.obryv_ryada_error = first_error;
        this.okryglenie_error = second_error;
    }
}

public class Main {
    //           x^(2k + 1)
    // (-1)^x * -----------
    //           (2k + 1)

    // половина машинного эпсилон (ULP / 2),
    // расстояние между 1.0 и следующим большим числом с плавающей точкой для оценки ошибок округления
    public static double U = Math.ulp(1.0) / (2.0);

    //коэффициент оценивает рост погрешности при суммировании n чисел
    //как растет ошибка при сложении чисел
    public static double gamma(int n) {
        return n * U / (1 - n * U);
    };

    public static Result arctangens(double x, int nMax) {
        double ones = 1.0; //переменная для чередования знаков (-1 и 1)
        double sum = 0.0; //сумма ряда
        double numerator = x; //числитель
        double denominator = 0.0; //знаменатель
        double squaredx = x * x; // х^2

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
        }

        // вычисление ошибки представления - разница между истинным значением числа
        //и его приближённым представлением в компьютере из-за ограничений формата данных
        double predstavleniya_error = sum/(1+U);

        //Оценка погрешности обрыва ряда (остаточного члена ряда) с учетом погрешности округления самой оценки
        // |s - s_nMax| <= 1 / ((nMax + 1) * (nMax + 1));
        //возвращает величину наименьшего значащего разряда
        double obryv_ryada_error = 1 / ((nMax + 1.0) * (nMax + 1));
        obryv_ryada_error += Math.ulp(obryv_ryada_error);

        //Оценка погрешности, возникающей из-за округления каждого члена ряда
        double okryglenie_error = 0.0;
        for(int i = 0; i < nMax; i++) {
            okryglenie_error +=  Math.abs(fraction[i]);
        }

        return new Result(sum, fraction, sumArray, predstavleniya_error, obryv_ryada_error, okryglenie_error);
    };

    public static void main(String[] args) {
        int nMaxx = 11; //количество членов ряда x
        int nMaxy = 4; //количество членов ряда y
        double pi = PI;

        double x = 1.0/5.0;
        double y = 1.0/239.0;

        Result arctanx = arctangens(x, nMaxx);
        Result arctany = arctangens(y, nMaxy);

        //ошибка представления
//        System.out.println("Ошибка представления x = " + arctanx.predstavleniya_error);
//        System.out.println("Ошибка представления y = " + arctany.predstavleniya_error);

        //х
        //Оценка погрешности суммирования с ростом оценки суммирования
        double sum_errorx = gamma(nMaxx - 1) * arctanx.okryglenie_error;
        arctanx.okryglenie_error *= U;
//        System.out.println("sum = " + arctanx.sum);
//        System.out.println("Ошибка обрыва ряда x = " + arctanx.obryv_ryada_error);
//        System.out.println("Ошибка округления x = " + arctanx.okryglenie_error);
//        System.out.println("Ошибка суммирования x = " + sum_errorx);

        //абсолютная погрешность
        double abs_errorx = sum_errorx + arctanx.okryglenie_error + arctanx.obryv_ryada_error;
        //System.out.println("Абсолютная погрешность x = " + abs_errorx);

//        //общая погрешность
//        double total_error_in_ULPx = abs_errorx / Math.ulp(arctanx.sum);
//        System.out.println("Общая погрешность x = " + total_error_in_ULPx);
//        System.out.println("Общая погрешность x = " + Math.log(total_error_in_ULPx) / Math.log(2.0));

        //у
        double sum_errory = gamma(nMaxy - 1) * arctany.okryglenie_error;
        arctany.okryglenie_error *= U;
//        System.out.println("sum = " + arctanx.sum);
//        System.out.println("Ошибка обрыва ряда y = " + arctany.obryv_ryada_error);
//        System.out.println("Ошибка округления y = " + arctany.okryglenie_error);
//        System.out.println("Ошибка суммирования y = " + sum_errory);

        //абсолютная погрешность
        double abs_errory = sum_errory + arctany.okryglenie_error + arctany.obryv_ryada_error;
       // System.out.println("Абсолютная погрешность y = " + abs_errory);

//        //общая погрешность
//        double total_error_in_ULPy = abs_errory / Math.ulp(arctanx.sum);
//        System.out.println("Общая погрешность y = " + total_error_in_ULPy);
//        System.out.println("Общая погрешность y = " + Math.log(total_error_in_ULPy) / Math.log(2.0));


        double result = 4.0 * (4.0 * arctanx.sum - arctany.sum);
        double atanx16 = 16.0 * arctanx.sum;
        double atany4 = 4.0 * arctany.sum;
        double atanx16MinusAtany4 = atanx16 - atany4;


        double umn_error = atanx16*U + atany4*U;
        double raznost_error = atanx16MinusAtany4*U;
        double atanx16MinusAtany4_error = atanx16*U + atany4*U;

        double total_error = abs_errorx + abs_errory + raznost_error + atanx16MinusAtany4_error;
        System.out.println("total_error = " + total_error);

        // погрешность при умножении и вычитании
        System.out.println("result = " + result);

        // вычисление абсолютной ошибки
        double absMistake = abs(pi - result);
        // вычисление относительной ошибки
        double relativeMistake = abs((abs_errorx + abs_errory) / result);

        System.out.println("Относительная ошибка = " + BigDecimal.valueOf(relativeMistake).toPlainString());

//        System.out.printf("Абсолютная ошибка = %.20f%n", absMistake);
//        System.out.printf("Относительная ошибка = %.20f%n", relativeMistake);

//        System.out.println("Дробь x=" + x + ":");
//        System.out.println(Arrays.toString(arctanx.fraction));
//
//        System.out.println("Дробь y=" + y + ":");
//        System.out.println(Arrays.toString(arctany.fraction));
//
//        System.out.println("Сумма дроби x=" + x + ":");
//        System.out.println(Arrays.toString(arctanx.sumArray));
//
//        System.out.println("Сумма дроби y=" + y + ":");
//        System.out.println(Arrays.toString(arctany.sumArray));

    }
}