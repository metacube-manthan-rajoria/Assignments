import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

final class PolyOperation {
    private final int coefficients[];
    private final int powers[];
    private final int termsArray[][];
    private final HashMap<Integer, Integer> terms = new HashMap<Integer, Integer>();

    public PolyOperation(int terms[][]){
        coefficients = new int[terms.length];
        powers = new int[terms.length];
        termsArray = terms;

        for(int i = 0; i<terms.length; i++){
            coefficients[i] = terms[i][0];
            powers[i] = terms[i][1];
            this.terms.put(terms[i][0], terms[i][1]);
        }
    }

    public static int[][] addPoly(PolyOperation polynomial1, PolyOperation polynomial2){
        int poly1Length = polynomial1.getLength();
        int poly2Length = polynomial2.getLength();
        int poly1Degree = polynomial1.degree();
        int poly2Degree = polynomial2.degree();

        int result[][] = new int[poly1Length + poly2Length][2];

        int biggerDegree = poly1Degree >= poly2Degree ? poly1Degree : poly2Degree;
        for(int i = 0; i<=biggerDegree; i++){
            int sum = 0;
            for(int j = 0; j<poly1Length; j++){
                if(polynomial1.getTermsArray()[j][1] == i){
                    sum += polynomial1.getTermsArray()[j][0];
                }
            }
            for(int j = 0; j<poly2Length; j++){
                if(polynomial2.getTermsArray()[j][1] == i){
                    sum += polynomial2.getTermsArray()[j][0];
                }
            }
            result[i][0] = sum;
            result[i][1] = i;
        }

        int validTerms = 0;
        for(int i = 0; i<result.length; i++){
            if(result[i][0] != 0){
                validTerms++;
            }
        }

        int normalisedResult[][] = new int[validTerms][2];
        int normalisedResultIndex = 0;
        for(int i = 0; i<=validTerms; i++){
            if(result[i][0] != 0){
                normalisedResult[normalisedResultIndex][0] = result[i][0];
                normalisedResult[normalisedResultIndex][1] = result[i][1];
                normalisedResultIndex++;
            }
        }

        return normalisedResult;
    }

    public static int[][] multiplyPoly(PolyOperation polynomial1, PolyOperation polynomial2){
        int poly1Length = polynomial1.getLength();
        int poly2Length = polynomial2.getLength();
        int poly1Degree = polynomial1.degree();
        int poly2Degree = polynomial2.degree();

        int result[][] = new int[poly1Length + poly2Length][2];
    }

    public float evaluate(float value){
        double sum = 0;
        for(int i = 0; i<coefficients.length; i++){
            sum += coefficients[i] * Math.pow(value, powers[i]);
        }
        return (float)sum;
    }

    public int degree(){
        int maxDegree = 0;

        for(int i = 0; i<powers.length; i++){
            if(maxDegree < powers[i]) maxDegree = powers[i];
        }

        return maxDegree;
    }

    public int getLength(){
        return this.termsArray.length;
    }

    public int[][] getTermsArray(){
        return this.termsArray;
    }
}   

public class Assignment{
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);

            int numberOfTerms1 = 0;
            System.out.print("Enter number of terms for equation 1 : ");
            numberOfTerms1 = scanner.nextInt();
            int terms1[][] = new int[numberOfTerms1][2];

            for(int i = 0; i<numberOfTerms1; i++){
                System.out.println();
                System.out.print("Enter coefficient for term " + (i + 1) + " : ");
                int coefficient = scanner.nextInt();
                System.out.print("Enter power for term " + (i + 1) + " : ");
                int power = scanner.nextInt();
                terms1[i][0] = coefficient;
                terms1[i][1] = power;
            }

            System.out.println();
            int numberOfTerms2 = 0;
            System.out.print("Enter number of terms for equation 2 : ");
            numberOfTerms2 = scanner.nextInt();
            int terms2[][] = new int[numberOfTerms2][2];

            for(int i = 0; i<numberOfTerms2; i++){
                System.out.println();
                System.out.print("Enter coefficient for term " + (i + 1) + " : ");
                int coefficient = scanner.nextInt();
                System.out.print("Enter power for term " + (i + 1) + " : ");
                int power = scanner.nextInt();
                terms2[i][0] = coefficient;
                terms2[i][1] = power;
            }
            
            scanner.close();

            PolyOperation polyOperation1 = new PolyOperation(terms1);
            PolyOperation polyOperation2 = new PolyOperation(terms2);
            System.out.println(polyOperation1.evaluate(2));

            int arr[][] = PolyOperation.addPoly(polyOperation1, polyOperation2);


            for(int i = 0; i<arr.length; i++){
                System.out.print(arr[i][0] + "x^" + arr[i][1] + " ");
            }
        }catch(InputMismatchException e){
            System.out.println("Input Mismatch");
        }
    } 
}


             

     

          

                                       

        

        

                    