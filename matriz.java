//package matrix;
import java.util.InputMismatchException;
import java.util.Scanner;

public class matriz{
// matrices iniciales
public static int[][]one;
public static int[][]two;
//dimensiones de las matrices iniciales
public static int m; //filas de la primera matriz
public static int n; //columnas de la primera matriz(Será la fila de la segunda para multiplicación)
public static int n2; //columnas de la segunda matriz
public static int s; //Para la multiplicación

public static void main(String[]args) {
makeproblem();
}

public static void makeproblem() {
    int ans = 0;
Scanner sc= new Scanner(System.in);
System.out.println("Qué operación quiere realizar?\n 1.- Suma\n 2.-  Resta\n 3.- Multiplicación\n 4.- Transposición\n 5.- Exit"); 
do{try{ans= sc.nextInt();}
catch(InputMismatchException e){
System.out.println("Inserte un input valido (entero 1-5)");
makeproblem();
}
} while(ans==0);

switch(ans){
    case 1:
     sum();
     break;
    case 2:
     sub();
     break;
    case 3:
     mult();
     break; 
    case 4:
     transp();
     break;
    case 5:
     System.exit(0);
     break;
    default:
     makeproblem();
}
sc.close();
    }
//          operaciones
public static void sum() { //suma
Scanner sc = new Scanner(System.in);
System.out.println(" Primera matriz\n");
row();
col();
one=makematrix(m, n);
System.out.println(" Segunda matriz \n Las dimensiones serán las mismas que la primer matriz");
two=makematrix(m, n);

int[][]sum2= new int[m][n];
for(int i=0; i<m; i++){
for(int j=0; j<n; j++){
	sum2[i][j]=one[i][j]+two[i][j];
}

System.out.println(" Matriz resultante:");
pt(sum2);
}
sc.close();
}

public static int[][] Trans(int[][] input) { //Transpuesta
    System.out.println("\n");
    int Trans[][]=new int[input[0].length][input.length];
    for (int i = 0; i < input.length; i++) {
        for (int j = 0; j < input[0].length; j++) {
           Trans[j][i]=input[i][j];
        }
    }
   System.out.println("Transpuesta: ");
   pt(Trans); 
    System.out.println();
    return Trans;
}

public static void sub() { //Resta
Scanner sc = new Scanner(System.in);
System.out.println("Primera matriz\n");
row();
col();
one=makematrix(m, n);
System.out.println(" Segunda matriz \n Las dimensiones serán las mismas que la primer matriz");
two=makematrix(m, n);

int[][]sub2= new int[m][n];
for(int i=0; i<m; i++){
for(int j=0; j<n; j++){
sub2[i][j]=one[i][j]-two[i][j];
}
System.out.println("Matriz resultante:");
pt(sub2);
}
sc.close();
}

public static void transp() { //Void para Transposición
System.out.println("Transpose");
row();
col();
System.out.println();
int[][]out=makematrix(m,n);
Trans(out);
}

public static void mult(){ //Multiplicacion
Scanner sc = new Scanner(System.in);
row();
col();
one=makematrix(m, n);
System.out.println();
System.out.println("Segunda matriz \nLas filas serán "+n+"\nInserte columnas");
n2=sc.nextInt();
two=makematrix(n, n2);
int[][]atb=new int[m][n2];
for(int i=0; i<one.length; i++){
 for(int j=0; j<two[0].length; j++){
 for (int k = 0;k <two.length; k++) {
     s+=one[i][k]*two[k][j]; 
 }
 atb[i][j]+=s;
 s=0;
 }
}
pt(atb);
sc.close();
}

//Otras cosas
   public static int[][] makematrix(int ro, int co) { //método para crear la matriz
        int[][] makematrix = new int[ro][co];
        gv(makematrix, ro, co);
        System.out.println("\n Matriz inicial : ");
        pt(makematrix);
        return makematrix;
   } 

static void gv(int[][]input, int r,int c){ //Éste metodo le da valores individuales a los elementos de las matrices
	for(int i=0; i<r; i++){
	for(int j=0; j<c; j++){
	System.out.print(" Inserte elemento"+(i+1)+(j+1)+":   ");
 individual(input, i, j);
	}
	}
}

public static void individual(int[][]input, int r,int c) { //Éste elemento se asegura que el input sea compatible
	Scanner l = new Scanner(System.in);
	try{input[r][c]=l.nextInt();}
    catch(InputMismatchException e){
System.out.println("Inserte un input valido (entero)");
individual(input, r, c);
    }
}

static void pt(int[][]input){ //Imprimir matriz
System.out.println();
for(int i=0; i<input.length; i++){
	System.out.println();
for(int j=0; j<input[0].length; j++){
 System.out.printf("%5d ",input[i][j]);
    }
    }
System.out.println();
}

public static void row() { //Pregunta la cantidad de filas 
Scanner sc = new Scanner(System.in);
System.out.println("Inserte cantidad de filas");
try{m= sc.nextInt();}
catch(InputMismatchException e ){
System.out.println("Inserte un input valido (entero)");
row();
}
}

public static void col() {//Pregunta la cantidad de columnas
Scanner sc = new Scanner(System.in);
System.out.println("Inserte cantidad de columnas");
try{n= sc.nextInt();}
catch(InputMismatchException e){
System.out.println("Inserte input compatible (Entero)");
col();
}
}
}
