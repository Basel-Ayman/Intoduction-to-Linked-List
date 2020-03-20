package eg.edu.alexu.csd.datastructure.linkedList.cs18_cs52;

import static org.junit.Assert.*;
import org.junit.Test;

public class PolynomialSolverTest {
    @Test
    public void AdditionTest() {
        //Test_1
        PolynomialSolver polynomialSolver = new PolynomialSolver();
        int[][] first = {{9, 11},{5,8}, {3,7},{2,4}};
        int[][] second = {{7,8},{6,2},{3,3},{1,0}};
        polynomialSolver.setPolynomial('A',first);
        polynomialSolver.setPolynomial('B',second);
        int[][] result = polynomialSolver.add('A','B');
        int[][] expected = {{9,11},{12,8},{3,7},{2,4},{3,3},{6,2},{1,0}};
        assertArrayEquals(expected,result);
        //Test_2
        int[][] First = {{-1, 2}, {3, 4}};
        int[][] Second = {{5, 4}, {-6, 7}};
        polynomialSolver.setPolynomial('C', First);
        polynomialSolver.setPolynomial('D', Second);
        int[][] Result = polynomialSolver.add('C', 'D');
        int[][] Expected = {{-6, 7}, {8, 4}, {-1, 2}};
        assertArrayEquals(Expected, Result);
    }
    @Test
    public void SubtractTest() {
        //Test_1
        PolynomialSolver polynomialSolver = new PolynomialSolver();
        int[][] first = {{8,4},{6,3},{4,2},{1,0}};
        int[][] second = {{7,4},{5,3},{2,1},{1,0}};
        polynomialSolver.setPolynomial('A',first);
        polynomialSolver.setPolynomial('B',second);
        int[][] result = polynomialSolver.subtract('A', 'B');
        int[][] expected = {{1,4},{1,3},{4,2},{-2,1}};
        assertArrayEquals(expected, result);
        //Test_2
        int[][] First = {{-1, 2}, {3, 4}};
        int[][] Second = {{5, 4}, {-6, 7}};
        polynomialSolver.setPolynomial('C', First);
        polynomialSolver.setPolynomial('D', Second);
        int[][] Result = polynomialSolver.subtract('C', 'D');
        int[][] Expected = {{6, 7}, {-2, 4}, {-1, 2}};
        assertArrayEquals(Expected, Result);
    }
    @Test
    public void MultiplyTest() {
        //Test_1
        PolynomialSolver polynomialSolver = new PolynomialSolver();
        int[][] first = {{-13,3}, {12,8}, {3,9}};
        int[][] second = {{10,0}};
        polynomialSolver.setPolynomial('A',first);
        polynomialSolver.setPolynomial('B',second);
        int[][] result = polynomialSolver.multiply('A','B');
        int[][] expected = {{30,9},{120,8},{-130,3}};
        assertArrayEquals(expected,result);
        //Test_2
        int[][] First = {{-1, 2}, {3, 4}};
        int[][] Second = {{5, 4}, {-6, 7}};
        polynomialSolver.setPolynomial('C', First);
        polynomialSolver.setPolynomial('D', Second);
        int[][] Result = polynomialSolver.multiply('C', 'D');
        int[][] Expected = {{-18, 11}, {6, 9}, {15, 8}, {-5, 6}};
        assertArrayEquals(Expected, Result);
    }
    @Test
    public void EvaluateTest() {
        //Test_1
        PolynomialSolver polynomialSolver = new PolynomialSolver();
        int[][] first = {{7,4},{2,2},{8,6}};
        polynomialSolver.setPolynomial('A',first);
        int result = (int) polynomialSolver.evaluatePolynomial('A',3);
        int expected =  6417;
        assertEquals(expected,result);
        //Test_2
        int[][] First = {{-1, 2}, {3, 4}};
        polynomialSolver.setPolynomial('B', First);
        int Result = (int) polynomialSolver.evaluatePolynomial('B', 8);
        int Expected = 12224;
        assertEquals(Expected, Result);
    }

}