import enums.*;

public class People{
    public Color c= null;
    public Nationality n = null;
    public Beverage b =null;
    public Cigar cgr= null;
    public Pet p=null;
    
  
    public People()
    {
       super();
    }
    public int result()
    {
        int i=0;
        i+= (c!=null) ? 1 :0;
        i+= (n!=null) ? 1 :0;
        i+= (b!=null) ? 1 :0;
        i+= (cgr!=null) ? 1 :0;
        i+= (p!=null) ? 1 :0;

        return i;

    }

    public void clone(People pe){
        this.c =pe.c;
        this.n =pe.n;
        this.b =pe.b;
        this.cgr =pe.cgr;
        this.p =pe.p;

    }
    // 지역 피부색.
    public People(Nationality n ,Color c){
        super();
        this.n = n;
        this.c = c;
    }
    // 지역 애완동물
    public People(Nationality n ,Pet p){
        super();
        this.n = n;
        this.p = p;
    }
    //지역 음료.
    public People(Nationality n ,Beverage b){
        super();
        this.n = n;
        this.b = b;
    }

    public People(Nationality n)
    {
        super();
        this.n = n;
    }
    //초기화 
    public People(Color c,Nationality n, Beverage b,Cigar cgr,Pet p)
    {
        this.c =c;
        this.n = n;
        this.b = b;
        this.cgr =cgr;
        this.p = p;
    }

}
