package Test;

public class Main {
    public static void main(String[] args) {
        Puk puk = new Puk();
        Slup slup = new Slup();
        Buk buk = new Buk();

        new Main().test(slup);
    }
    public Puk test(Puk puk) {
        Buk b = puk;
        return new Slup();
    }

    static class Buk {

    }
    static class Puk extends Buk {

    }

    static class Slup extends Puk {

    }
}
