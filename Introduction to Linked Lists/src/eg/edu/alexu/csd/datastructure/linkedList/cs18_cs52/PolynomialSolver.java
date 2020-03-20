package eg.edu.alexu.csd.datastructure.linkedList.cs18_cs52;

public class PolynomialSolver implements IPolynomialSolver {

    static class Var {
        char name;
        SLinkedList equation = new SLinkedList();
    }
    Var[] arrayOfLists = new Var[10];

    @Override
    public void setPolynomial(char poly, int[][] terms) {
        int maxInt = -2147483648;
        int count = 0;
        for (int i=0; i<terms.length-1; i++) {
            for (int j=0; j<terms.length-i-1; j++) {
                if (terms[j][1] > terms[j+1][1]) {
                    int[] temp = terms[j];
                    terms[j] = terms[j+1];
                    terms[j+1] = temp;
                }else if (terms[j][1] == terms[j+1][1]) {
                    terms[j][0] += terms[j+1][0];
                    terms[j+1][1] = maxInt++;
                    j--;
                    count++;
                }
            }
        }
        int flag = -1;
        for(int i = 0; i< arrayOfLists.length; i++) {
            if(arrayOfLists[i]==null) {
                flag = i;
                break;
            }
        }
        if(flag==-1) {
            throw new RuntimeException("No space for more polynomials, you can remove some");
        }
        arrayOfLists[flag] = new Var();
        arrayOfLists[flag].name = poly;
        for(int i=terms.length-1 ; i>=count; i--) {
            if(terms[i][0]!=0) {
                arrayOfLists[flag].equation.add(terms[i]);
            }
        }
    }

    @Override
    public String print(char poly) {
        StringBuilder rep = new StringBuilder("");
        int current = this.getPolyIndex(poly);
        for (int i = 0; i< arrayOfLists[current].equation.size(); i++) {
            boolean coefOne, coefNOne, powerOne, powerZero;
            coefOne = this.getValue(poly, i)[0] == 1;
            coefNOne = this.getValue(poly, i)[0] == -1;
            powerOne = this.getValue(poly, i)[1] == 1;
            powerZero = this.getValue(poly, i)[1] == 0;
            if (powerZero) {
                rep.append(this.getValue(poly, i)[0]);
            }else if (powerOne && coefOne) {
                rep.append("x");
            }else if (powerOne && coefNOne) {
                rep.append("-x");
            }else if (coefOne) {
                rep.append(String.format("x^%d", this.getValue(poly, i)[1]));
            }else if (coefNOne) {
                rep.append(String.format("-x^%d", this.getValue(poly, i)[1]));
            }else if(powerOne) {
                rep.append(String.format("%dx", this.getValue(poly, i)[0]));
            }else {
                rep.append(String.format("%dx^%d", this.getValue(poly, i)[0], ((int[]) (arrayOfLists[current].equation.get(i)))[1]));
            }
            if(arrayOfLists[current].equation.get(i+1)!=null && this.getValue(poly,i+1)[0]>0) {
                rep.append('+');
            }
        }
        return rep.toString();
    }

    @Override
    public void clearPolynomial(char poly) {
        int currentIndex = getPolyIndex(poly);
        arrayOfLists[currentIndex] = null;
    }

    @Override
    public float evaluatePolynomial(char poly, float value) {
        double polynomialValue = 0 ;
        int currentIndex = getPolyIndex(poly);
        int i = 0;
        while(arrayOfLists[currentIndex].equation.get(i) != null){
            polynomialValue += this.getValue(poly, i)[0] *Math.pow(value,this.getValue(poly, i)[1]);
            i++;
        }
        return (float)polynomialValue;
    }

    @Override
    public int[][] add(char poly1, char poly2) {
        SLinkedList sumOfPolynomials = new SLinkedList();
        int index1 = getPolyIndex(poly1);
        int index2 = getPolyIndex(poly2);
        int i = 0;
        int j = 0;
        while(i < arrayOfLists[index1].equation.size() && j < arrayOfLists[index2].equation.size()) {
            //if the two terms have the same exponent
            if(this.getValue(poly1, i)[1] == this.getValue(poly2, j)[1]){
                if(this.getValue(poly1, i)[0]+this.getValue(poly2, j)[0] != 0){
                    sumOfPolynomials.add(new int[]{this.getValue(poly1,i)[0]+this.getValue(poly2,j)[0],
                            this.getValue(poly1, i)[1]});
                }
                i++;
                j++;
            }
            //if one of the exponents is greater than the other one
            else if(this.getValue(poly1, i)[1] > this.getValue(poly2, j)[1]){
                sumOfPolynomials.add(new int[] {this.getValue(poly1, i)[0],this.getValue(poly1, i)[1]});
                i++;
            }else{
                sumOfPolynomials.add(new int[] {this.getValue(poly2, j)[0],this.getValue(poly2, j)[1]});
                j++;
            }
        }
        while(i < arrayOfLists[index1].equation.size()){
            sumOfPolynomials.add(new int[] {this.getValue(poly1, i)[0],this.getValue(poly1, i)[1]});
            i++;
        }
        while(j < arrayOfLists[index2].equation.size()){
            sumOfPolynomials.add(new int[] {this.getValue(poly2, j)[0],this.getValue(poly2, j)[1]});
            j++;
        }
        return (int[][])sumOfPolynomials.listToArr(true);
    }

    @Override
    public int[][] subtract(char poly1, char poly2) {
        int[][] subtractArray;
        int index2 = getPolyIndex(poly2);
        //add a negative sign to the second polynomial
        for(int i = 0 ; i < arrayOfLists[index2].equation.size();i++){
            ((int[])(arrayOfLists[index2].equation.get(i)))[0]= -((int[])(arrayOfLists[index2].equation.get(i)))[0];
        }
        //By Using add method
        subtractArray = add(poly1, poly2);
        // return second polynomial to its real values
        for(int i = 0 ; i < arrayOfLists[index2].equation.size();i++){
            ((int[])(arrayOfLists[index2].equation.get(i)))[0]= -((int[])(arrayOfLists[index2].equation.get(i)))[0];
        }
        return subtractArray;
    }

    @Override
    public int[][] multiply(char poly1, char poly2) {
        SLinkedList multiplyList = new SLinkedList();
        int index1 = getPolyIndex(poly1);
        int index2 = getPolyIndex(poly2);
        //Multiplication
        for(int i = 0; i < arrayOfLists[index1].equation.size();i++)
            for (int j = 0; j < arrayOfLists[index2].equation.size(); j++) {
                multiplyList.add(new int[]{this.getValue(poly1, i)[0]*this.getValue(poly2, j)[0],this.getValue(poly1, i)[1]+this.getValue(poly2, j)[1]});
            }
		/* throw the multiplication list to function setPolynomial because
        - setPolynomial function add terms with same exponent
        - remove terms with zero coefficient */
        this.setPolynomial('t', (int[][])multiplyList.listToArr(true));
        int mulPoly = this.getPolyIndex('t');
        int[][] mularray = (int[][])arrayOfLists[mulPoly].equation.listToArr(true);
        this.clearPolynomial('t');
        return mularray;
    }

    private int getPolyIndex(char poly) {
        if(isExist(poly)) {
            int current = 0;
            while(current< arrayOfLists.length && arrayOfLists[current].name!=poly) {
                current++;
            }
            return current;
        }else {
            throw new RuntimeException("Polynomial not found");
        }
    }

    private boolean isExist(char poly) {
        for (Var P1 : arrayOfLists)
            if (P1 != null && P1.name == poly) {
                return true;
            }
        return false;
    }

    private int[] getValue(char poly, int index) {
        int current = this.getPolyIndex(poly);
        return new int[]{((int[])(arrayOfLists[current].equation.get(index)))[0], ((int[])(arrayOfLists[current].equation.get(index)))[1]};
    }

}
