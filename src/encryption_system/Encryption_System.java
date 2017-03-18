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
        BigInteger solution = new BigInteger("0"); //This part still to be done
        return solution;
    }
    
    public static BigInteger[] encrypt_message(BigInteger n, BigInteger e,String message) {
        
        int len = message.length();
        char msg_char[] = new char[len];
        BigInteger msg_int[] = new BigInteger[len];
        BigInteger encrypted[] = new BigInteger[len];
        
        for(int i = 0;i<len;i++) {
            msg_char[i] = message.charAt(i);
            BigInteger temp = new BigInteger((""+((int)msg_char[i])));
            encrypted[i] = temp.modPow(e,n);
            System.out.println(encrypted[i] + "\n");
        }
        
        return encrypted;
    }
    
    public static String decrypt_message(BigInteger n, BigInteger d,BigInteger[] encrypted) {
        int len = encrypted.length;
        String decrypted = "";
        
        for(int i = 0;i<len;i++) {
            BigInteger temp = encrypted[i];
            temp = temp.modPow(d, n);
            String str = temp.toString();
            int msg = Integer.valueOf(str);
            decrypted += (char)msg;
        }
        
        return decrypted;
    }
    
      
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
         Encryption_System obj1 = new Encryption_System();
         System.out.println("Public Key : ("+n+", "+e+")\n");
        
        String message = br.readLine();
        
        BigInteger encrypted_form[] = encrypt_message(n,e,message);
        
        String decrypted = decrypt_message(n,e,encrypted_form);
        
        System.out.println(decrypted);
        
        //System.out.println(n);
        
    }
    
}
