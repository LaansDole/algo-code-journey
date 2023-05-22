package RMIT.Test2_2023A;

//XA < XB (i.e., A is on the left of B)
//YA > 0 (i.e., A is above line L)
//YB < 0 (i.e., B is below line L)
//VA, VB > 0

import java.text.DecimalFormat;

public class SecretSearch {
    double XA;
    double YA;
    double VA;
    double XB;
    double YB;
    double VB;
    public SecretSearch(double XA, double YA, double VA, double XB, double YB, double VB) {
        this.XA = XA;
        this.YA = YA;
        this.VA = VA;
        this.XB = XB;
        this.YB = YB;
        this.VB = VB;
    }

    private static double decimalFormat(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.######");
        return Double.parseDouble(decimalFormat.format(number));
    }

    private static double getDistanceFromCoordinate(double X1, double X2, double Y1, double Y2) {
        return Math.sqrt(Math.pow((X1-X2), 2) + Math.pow((Y1-Y2), 2));
    }

    // return the minimum time agent A can reach line L
    public double minTimeA() {
        double YZ = 0;
        double XZ = this.XA;
        return decimalFormat(getDistanceFromCoordinate(XA, XZ, YA, YZ)/VA);
    }

    public double timeFromA(double XZ) {
        return decimalFormat(getDistanceFromCoordinate(XA, XZ, YA, 0)/VA);
    }

    public static void main(String[] args) {
        SecretSearch s1 = new SecretSearch(-1, 1, 1, 1, -1, 0.5);
        System.out.println(s1.minTimeA());
        System.out.println(s1.timeFromA(0));
//        System.out.println(s1.pointC());

    }
}
