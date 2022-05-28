import enums.*;
import java.util.Random;

public class list{
    public Color c;
    public Cigar cgr;
    public Nationality n;
    public Beverage b;
    public Pet p;
    private Random r;

    public list(){
        c =null;
        cgr =null;
        n=null;
        b=null;
        p=null;
        r= new Random();
    }
    // 지역 피부색.
    public list(Nationality n ,Color c){
        super();
        this.n = n;
        this.c = c;
    }
    // 지역 애완동물
    public list(Nationality n ,Pet p){
        super();
        this.n = n;
        this.p = p;
    }
    //지역 음료.
    public list(Nationality n ,Beverage b){
        super();
        this.n = n;
        this.b = b;
    }

    public list(Nationality n)
    {
        super();
        this.n = n;
    }

}