import enums.*;

public class test {
   public static void main(String[] args) {
    People[] p= new People[5];
    
    for(int i =0; i<p.length;i++)
    {
        p[i] = new People();
    }
 



    if((p[0].c==Color.red||p[0].c!=null&&p[0].n!=Nationality.Brit))
    {
        System.out.println("출력");
    }
    for (People people : p) {
        System.out.println(people.c);
    }
   }

    
}
