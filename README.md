
# mat

a somewhat functional matrix implementation, supports adding subtracting and multiplying (and throws errors too!)\
to use: just build as a jar
```
cd Mat
javac *.java
jar cfv mat.jar *
```
```
double[][] array = new double[][] {{1., 3.}, {2., 5.}};
double[][] array2 = new double[][] {{0., 1.}, {3., 2.}};
Matrix d = new Matrix(array);
Matrix e = new Matrix(array2);
System.out.println(d.multiply(e));
System.out.println(d.add(e));
```
# docs
`public Matrix(int rows, int columns) throws MatrixException`\
`public Matrix(double[] array) throws MatrixException`\
`public Matrix(double[][] array) throws MatrixException`\
`public int getRows()`\
`public int getColumns()`\
`public double getValue(int row, int col) throws MatrixException`\
`public void forceSet(int row, int col, double n)`\
`public Matrix add(Matrix b) throws MatrixException`\
`public Matrix subtract(Matrix b) throws MatrixException`\
`public Matrix multiply(double scalar) throws MatrixException`\
`public Matrix multiply(Matrix b) throws MatrixException`\
`public Matrix transpose() throws MatrixException`\
`public String toString()`
