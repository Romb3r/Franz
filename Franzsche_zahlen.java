import java.util.Arrays;

class Franzsche_zahlen
{   
  public static boolean isPrime (int n)
  {
    if (n < 2) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    boolean bPrime = true;
    int divisor = 3;
    while (bPrime && (divisor * divisor <= n))
    {
      if (n % divisor == 0)
      {
        bPrime = false;
      }
      divisor+= 2;
    }
    return bPrime;
  }
  
  //return die Anzahl an Primzahlen bei insgesamt 1000 Prüfungen
  public static int getArraySize() {
    int array_size = 0;
    for (int i = 0; i <= 1000; i++) {
      if (isPrime(i)) {
        array_size++;
      }
    }
    return array_size;
  }
  
    
  public static void checkFranz() 
  {
    int array_size_prime = getArraySize();                        
    int[] prime_array = new int[array_size_prime];                //Primzahl-Array hat genau die richtige Größe um alle geprüften Primzahlen zu speichern
    int franz_zahl;
    int[] franz_array = new int[1000];
    int y = 0;
    int a = 0;
    
    //Füge alle Primzahlen der 1000 Prüfungen zum prime_array hinzu
    for (int i = 0; i < 1000; i++) {
      if (isPrime(i)) {
        prime_array[y] = i;
        y++;
      }
    }
    
    //Multipliziere alle Primzahlen miteinander um alle Franz'schen Zahlen zu erhalten. Speicher alle Franz'schen Zahlen im franz_array
    //Leider entstehen doppelte Einträge auf diese Weise
    for (int i = 0; i < prime_array.length; i++) {
      for (int x = 0; x < prime_array.length; x++ ) {
        if (a < franz_array.length) {                             //speichere nur 1000 Einträge
          franz_zahl = prime_array[i] * prime_array[x];
          franz_array[a] = franz_zahl;
          a++;
        }
        else {
          break;
        }
      }
    }
    
    Arrays.sort(franz_array);                                     //sortiere das Array für die Übersichtlichkeit
    
    //Gib das franz_array aus
    for (int i = 0; i < franz_array.length; i++) {
      System.out.println("Stelle: " + i + " Inhalt: " + franz_array[i]);
    }
  }
  
  public static void main (String [] args)
  {
    checkFranz();
  }
}
