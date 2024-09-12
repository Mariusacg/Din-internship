package org.example;

public class Main {

    final static int JUMATATE = Integer.MAX_VALUE / 2;
    public static int adunare(int numarul1, int numarul2) throws Exception
    {
        if(numarul1 > JUMATATE || numarul2 > JUMATATE)
            throw new Exception("Numarul prea mare ca input");
        if(numarul1 < 0 || numarul2 < 0)
            throw new Exception("Nu se accepta numere negative");

        return numarul1 + numarul2;
    }

    public static void main(String[] args) {
        try {
            System.out.println(adunare(321, 222));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}