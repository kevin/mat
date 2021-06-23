import java.util.Arrays;

public class Matrix {
	
	private double[][] table;
	
	public Matrix(int rows, int columns) throws MatrixException {
		
		if (rows < 1 || columns < 1) {
			
			throw new MatrixException("Invalid dimensions for matrix creation");
			
		}
		
		table = new double[rows][columns];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				table[r][c] = 0;
			}
		}
		
	}
	
	public Matrix(double[] array) throws MatrixException { // vector
		
		this(array.length, 1);
		
		for (int r = 0; r < array.length; r++) {
			table[r][0] = array[r];
		}
		
	}
	
	public Matrix(double[][] array) throws MatrixException { // using a 2d array as the data
		
		this(array.length, array[0].length);
		
		for (int r = 0; r < array.length; r++) {
			if (array[r].length != getColumns()) {
				throw new MatrixException("Cannot use jagged array to create a matrix");
			}
			for (int c = 0; c < array[r].length; c++) {
				table[r][c] = array[r][c];
			}
		}
		
	}
	
	public int getRows() {
		return table.length;
	}
	
	public int getColumns() {
		return table[0].length;
	}
	
	public double getValue(int row, int col) throws MatrixException {
		
		if (row >= getRows() || col >= getColumns() || row < 0 || col < 0) {
			throw new MatrixException("Invalid index");
		}
		
		return table[row][col];
		
	}

	public void forceSet(int row, int col, double n) throws MatrixException {
		
		if (row >= getRows() || col >= getColumns() || row < 0 || col < 0) {
			throw new MatrixException("Invalid index");
		}
		
		table[row][col] = n;

	}
	
	public Matrix add(Matrix b) throws MatrixException {
		
		if (getRows() != b.getRows() || getColumns() != b.getColumns()) {
			throw new MatrixException("Cannot add or subtract two matrices of different dimensions");
		}
		
		Matrix out = new Matrix(getRows(), getColumns());
		for (int r = 0; r < getRows(); r++) {
			for (int c = 0; c < getColumns(); c++) {
				out.forceSet(r, c, getValue(r, c) + b.getValue(r, c));
			}
		}
		return out;
		
	}
	
	public Matrix subtract(Matrix b) throws MatrixException {
		
		if (getRows() != b.getRows() || getColumns() != b.getColumns()) {
			throw new MatrixException("Cannot add or subtract two matrices of different dimensions");
		}
		
		Matrix out = new Matrix(getRows(), getColumns());
		for (int r = 0; r < getRows(); r++) {
			for (int c = 0; c < getColumns(); c++) {
				out.forceSet(r, c, getValue(r, c) - b.getValue(r, c));
			}
		}
		return out;
		
	}
	
	public Matrix multiply(double scalar) throws MatrixException {
		
		Matrix out = new Matrix(getRows(), getColumns());
		for (int r = 0; r < getRows(); r++) {
			for (int c = 0; c < getColumns(); c++) {
				out.forceSet(r, c, getValue(r, c) * scalar);
			}
		}
		return out;
		
	}
	
	public Matrix multiply(Matrix b) throws MatrixException {
		
		if (getColumns() != b.getRows()) {
			throw new MatrixException("(m x n) matrix must be multiplied by an (n x o) matrix");
		}
		
		Matrix out = new Matrix(getRows(), b.getColumns());
		
		for (int o = 0; o < b.getColumns(); o++) {
			for (int r = 0; r < getRows(); r++) {
				for (int c = 0; c < getColumns(); c++) {
					out.forceSet(r, o, out.getValue(r, o) + getValue(r, c) * b.getValue(c, o));
				}
			}
		}
		
		return out;
		
	}
	
	public Matrix transpose() throws MatrixException {
		
		Matrix out = new Matrix(getColumns(), getRows());
		
		for (int r = 0; r < getRows(); r++) {
			for (int c = 0; c < getColumns(); c++) {
				out.forceSet(c, r, getValue(r, c));
			}
		}
		
		return out;
		
	}
	
	public String toString() {
		
		StringBuilder out = new StringBuilder();
		for (int r = 0; r < getRows(); r++) {
			out.append(Arrays.toString(table[r]) + System.lineSeparator());
		}
		
		return out.toString().trim();
		
	}

}
