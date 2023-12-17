import java.io.Serializable;

public class Complex implements Serializable {
    private int real;
    private int imaginary;

    //constructor
    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex conjugate()
    {
        return new Complex(this.real, this.imaginary*-1);
    }

    public Complex addition(Complex complex2)
    {
        return new Complex(this.real+complex2.getReal(), this.imaginary+complex2.getImaginary());
    }

    public Complex subtract(Complex complex2)
    {
        return new Complex(this.real-complex2.getReal(), this.imaginary-complex2.getImaginary());
    }

    public Complex multiply(Complex complex2)
    {
        int realPart, imaginaryPart;
        realPart = this.real*complex2.getReal() - this.imaginary*complex2.getImaginary();
        imaginaryPart = this.real*complex2.getImaginary() + this.imaginary*complex2.getReal();
        return new Complex(realPart, imaginaryPart);
    }

    public Complex divide(Complex complex2)
    {
        Complex complex_conj = complex2.conjugate();
        Complex denominator = complex2.multiply(complex_conj);

        Complex numerator = this.multiply(complex_conj);

        return new Complex(numerator.getReal()/denominator.getReal(), numerator.getImaginary()/denominator.getReal());
    }

    @Override
    public String toString() {
        return real + "+" + imaginary + ("i");
    }

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }
}
