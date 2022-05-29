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
        for(int i =0; i<p.length;i++)
        {
            this.p[i]=new People();
        }
        //현재 값 Peoples에 넣기
        for(int i =0; i<p.length;i++)
        {
            this.p[i].clone(p[i]);
        }
        leftPeople=null;
        rightPeople=null;
        root=this;
        not=true;
    }
    //부모 연결.
    public Peoples(Peoples peo)
    {
        for(int i =0; i<p.length;i++)
        {
            this.p[i]=new People();
        }
        //현재 값 Peoples에 넣기
        for(int i =0; i<p.length;i++)
        {
            this.p[i].clone(peo.p[i]);
        }
        leftPeople=null;
        rightPeople=null;
        root=peo;
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
