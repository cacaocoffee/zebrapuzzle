import enums.*;
public class Peoples {
    People[] p =new People[5];
  
    public Peoples leftPeople;
    public Peoples rightPeople;
    public Peoples root;
    public boolean not;
    
    public void datainput(People p,int i){
        this.p[i].b= p.b;
        this.p[i].c= p.c;
        this.p[i].cgr= p.cgr;
        this.p[i].n= p.n;
        this.p[i].p= p.p;
    }
    public Peoples()
    {
        leftPeople=null;
        rightPeople=null;
        root=this;
        not=true;
    }
    public Peoples(People[] p)
    {
        for(int i=0;i<5;i++)
        {
            this.p[i].b= p[i].b;
            this.p[i].c= p[i].c;
            this.p[i].cgr= p[i].cgr;
            this.p[i].n= p[i].n;
            this.p[i].p= p[i].p;
    
        }
        leftPeople=null;
        rightPeople=null;
        root=this;
        not=true;
    }
    public Peoples(Peoples left, Peoples right, Peoples root)
    {
        leftPeople=left;
        rightPeople=right;
        this.root=root;
    }
    public boolean IsResult()
    {
        if(leftPeople.not==false&&rightPeople.not==false)
            return false;
        else
            return true;
    }

}
