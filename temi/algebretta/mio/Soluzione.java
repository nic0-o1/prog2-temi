package mio;


import java.util.Scanner;

public class Soluzione {

    public static Matrice getMatrice(final char tipo, final int[][] values){
        switch (tipo) {
            case 'Z':
                return new MatriceNulla(values[0][0]);
            case 'I':
                return new MatriceIdentità(values[0][0]);
            case 'D':
                return new MatriceDiagonale(values[0]);
            case ' ':
                return new MatriceDensa(values);
        }
        throw new IllegalArgumentException("Formato non riconosciuto");
    }
    public static void main(String[] args) {
        try(Scanner s = new Scanner(System.in)){
            while(s.hasNextLine()){
                String exp[] = Parser.partiOperazione(s.nextLine());
                char op = exp[1].charAt(0);
                if(op == '+') {
                    if(Parser.èVettore(exp[0]) && Parser.èVettore(exp[2])){
                        VettoreDenso v1  = new VettoreDenso(Parser.valoriVettore(exp[0]));
                        VettoreDenso v2  = new VettoreDenso(Parser.valoriVettore(exp[2]));
                        System.out.println(v1.più(v2));
                    }
                    else if(Parser.èMatrice(exp[0]) && Parser.èMatrice(exp[2])){
                        Matrice m1 = getMatrice(Parser.tipoMatrice(exp[0]), Parser.valoriMatrice(exp[0]));
                        Matrice m2 = getMatrice(Parser.tipoMatrice(exp[2]), Parser.valoriMatrice(exp[2]));
                        System.out.println(m1.più(m2));
                    }
                }
                else{
                    if(Parser.èScalare(exp[0])){
                        int alpha = Parser.valoreScalare(exp[0]);
                        if(Parser.èVettore(exp[2])){
                            VettoreDenso v1 = new VettoreDenso(Parser.valoriVettore(exp[2]));
                            System.out.println(v1.per(alpha));
                        }
                        else if(Parser.èMatrice(exp[2])){
                            Matrice m1 = getMatrice(Parser.tipoMatrice(exp[2]), Parser.valoriMatrice(exp[2]));
                            System.out.println(m1.per(alpha));
                        }
                    }
                    else if(Parser.èMatrice(exp[0])){
                        Matrice m1 = getMatrice(Parser.tipoMatrice(exp[0]), Parser.valoriMatrice(exp[0]));
                        if(Parser.èMatrice(exp[2])){
                            Matrice m2 = getMatrice(Parser.tipoMatrice(exp[2]), Parser.valoriMatrice(exp[2]));
                            System.out.println(m1.per(m2));
                        }
                        else if(Parser.èVettore(exp[2])){
                            VettoreDenso v2 = new VettoreDenso(Parser.valoriVettore(exp[2]));
                            System.out.println(m1.per(v2));
                        }
                    }
                }
            }
        }
    }
}
