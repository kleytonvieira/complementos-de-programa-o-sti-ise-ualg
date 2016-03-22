package my;
public class mainProgramFile {
  public static void main(String[] args) {
    int numbers[] = new int[10];
    
    for(int i = 0; i <=  15; ++i){
      try {
        numbers[i] = i;
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(e);
      }
      System.out.println("hello CP!"); //  now, it gets here!
    }
  }
}
