/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption_system;

import java.math.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author brijendra98
 */
public class Encryption_System {

    /**
     * @param args the command line arguments
     * 
     */
    
    static BigInteger p,q,p_1,q_1,n,totient,e,d;
    
    Encryption_System() {
        
        int bits = 256;
        
        BigInteger zero = new BigInteger("0");
        Random rnd = new Random();
        p = BigInteger.probablePrime(bits, rnd);
        q = BigInteger.probablePrime(bits, rnd);
        n = p.multiply(q);
        BigInteger one = new BigInteger("1");
        p_1 = p.subtract(one);
        q_1 = q.subtract(one);
        totient = p_1.multiply(q_1);    
                
        while(true) {
            Random num = new Random();
            BigInteger probable_e = BigInteger.probablePrime(128, num);
            if(!(zero.equals(totient.mod(probable_e)))) {
                e = probable_e;
                //System.out.println(probable_e);
                break;
            }
        }
        
        d = solve_diophantine(totient.negate(),e,one);
    }
    
    public static BigInteger solve_diophantine(BigInteger a, BigInteger b, BigInteger c) {
        BigInteger x,y;
        BigInteger solution = new BigInteger("0");
        return solution;
    } 
    
      
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String message = br.readLine();
        int len = message.length();
        char msg_char[] = new char[len];
        BigInteger msg_int[] = new BigInteger[len];
        
        for(int i = 0;i<len;i++) {
            msg_char[i] = message.charAt(i);
        }
        
        Encryption_System obj1 = new Encryption_System();
        
        System.out.println(totient + "\n" + e);
        
        
        
        
        
        //System.out.println(n);
        
    }
    
}
