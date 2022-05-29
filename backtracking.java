import enums.*;
import java.util.Random;
public class backtracking {
    public static void main(String[] args) {
        
        People[] p= new People[5];
        Peoples peoples=new Peoples();
    
        for(int i =0; i<p.length;i++)
        {
            p[i] = new People();
        }
        // 주어진 조건에 의해 확실한 사실들 넣기
        p[2].b=Beverage.milk;
        p[1].c=Color.blue;
        p[0].n=Nationality.Norwegian;
        for(int i =0; i<p.length;i++)
        {
            peoples.p[i]=new People();
        }
        //현재 값 Peoples에 넣기
        for(int i =0; i<p.length;i++)
        {
            peoples.p[i].clone(p[i]);
        }
        back(peoples);
    }

    public static void back(Peoples peoples)
    {
        peoples.leftPeople= new Peoples(peoples);
        peoples.rightPeople =new Peoples(peoples);
        
       
        if(promising(peoples))
        {
            //25개 꽉찬 상태라면 출력 
            if(result(peoples)){
                print_result(peoples.p);
            }else 
            {//자식으로 이동
                if(peoples.leftPeople.not==true)
                {
                    //peoples 객체에 값추가 필요.
                    
                    addData(peoples.leftPeople);
                   
                    back(peoples.leftPeople);
                }
                else if(peoples.rightPeople.not==true)
                {
                    back(peoples.rightPeople);
                }
                else 
                    back(peoples.root);
    
            }

        }else {
            peoples.not =false;

        }

    }
    

    public static void addData(Peoples peoples)
    {
        
        int k=new Random().nextInt(Color.values().length);
        for(int i =0; i<5 ; i++)
        {
            if(peoples.p[i].c==null)
            {
                int count=0;
                for(int j =0;j<i;j++)
                {
                    if(peoples.p[j].c==Color.values()[k])
                        count++;
                }
                if(count==0){
                    peoples.p[i].c = Color.values()[k];
                    return;
                }
            }
        }
        for(int i =0; i<5 ; i++)
        {
            if(peoples.p[i].n==null)
            {
                int count=0;
                for(int j =0;j<i;j++)
                {
                    if(peoples.p[j].n==Nationality.values()[k])
                    count++;
                }
                if(count==0){
                    peoples.p[i].n = Nationality.values()[k];
                    return;
                }
            }
        }
        for(int i =0; i<5 ; i++)
        {
            if(peoples.p[i].b==null)
            {
                int count=0;
                for(int j =0;j<i;j++)
                {
                    if(peoples.p[j].b==Beverage.values()[k])
                        k++;
                }
                if(count==0){
                    peoples.p[i].b = Beverage.values()[k];
                    return;
                }
            }
        }
        for(int i =0; i<5 ; i++)
        {
            if(peoples.p[i].cgr==null)
            {
                int count =0;
                for(int j =0;j<i;j++)
                {
                    if(peoples.p[j].cgr==Cigar.values()[k])
                        count++;
                }
                if(count==0){
                    peoples.p[i].cgr = Cigar.values()[k];
                    return;
                }
            }
        }
        for(int i =0; i<5 ; i++)
        {
            int count=0;
            if(peoples.p[i].p==null)
            {
                for(int j =0;j<i;j++)
                {
                    if(peoples.p[j].p==Pet.values()[k])
                        count++;
                }
                if(count==0){
                    peoples.p[i].p = Pet.values()[k];
                    return;
                }
            }
        }
    }

    public static boolean result(Peoples peoples)
    {
        int re=0;
        System.out.println("실행");
        for(int i=0; i<5;i++)
        {
            re +=peoples.p[i].result();
        }
        if(re==25)
        {
            return true;
        }
        else  return false;

    }
    
    public static void print_result(People[] p)
    {
        //최종 출력
        for(int i=0; i<p.length;i++)
        {
            System.out.println(i+1+"-"+p[i].c+"-"+p[i].n+"-"+p[i].b+"-"+p[i].cgr+"-"+p[i].p);
        }
        System.out.println();
    }

    
    public static boolean promising(Peoples peoples)
    {
        int a=0;
        for(int i=0;i<5;i++)
        {
            //영국인은 빨간집에 산다.
            if(peoples.p[i].c==Color.red&&peoples.p[i].n==Nationality.Brit)
            {
                a+=0;
            }else if(peoples.p[i].c==null||peoples.p[i].n==null)
            {
                a+=0;
            }else a+=1;
            
            //스웨덴인 개를 기른다.
            if(peoples.p[i].n==Nationality.Swede&&peoples.p[i].p==Pet.dog)
            {
                a+=0;
            }else if(peoples.p[i].n==null||peoples.p[i].p==null)
            {
                a+=0;
            }else a+=1;
            
            //덴마크 사람은 차를 마신다.
            if(peoples.p[i].n==Nationality.Dane&&peoples.p[i].b==Beverage.tea)
            {
                a+=0;
            }else if(peoples.p[i].n==null||peoples.p[i].b==null)
            {
                a+=0;
            }else a+=1;
            
            //초록색 집은 하얀집의 왼쪽집이다.
            if(i!=4){
                if(peoples.p[i].c ==Color.green && peoples.p[i+1].c==Color.white)
                a+=0;
                else if(peoples.p[i].c ==null || peoples.p[i+1].c==null)
                a+=0;
                else  a+=1;
            }
            //초록집에 사는 사람은 커피를 마심
            if(peoples.p[i].b==Beverage.coffee&&peoples.p[i].c==Color.green)
            {
                a+=0;
            }else if(peoples.p[i].b==null||peoples.p[i].c==null)
            {
                a+=0;
            }else a+=1;

            //펠몰 담배 -새
            if(peoples.p[i].cgr==Cigar.Pall_Mall&&peoples.p[i].p==Pet.bird)
            {
                a+=0;
            }else if(peoples.p[i].cgr==null||peoples.p[i].p==null)
            {
                a+=0;
            }else a+=1;
            //노란집 - 던힐
            if(peoples.p[i].c ==Color.yellow && peoples.p[i].cgr ==Cigar.Dunhill)
            {
                a+=0;
            }else if(peoples.p[i].c ==null || peoples.p[i].cgr ==null)
            {
                a+=0;
            } else a+=1;
            //블렌드 담배 -옆집 고양이 키움
            if(i<4)
            {
                if(peoples.p[i].cgr ==Cigar.Blend && peoples.p[i+1].p==Pet.cat)
                a+=0;
                else if(peoples.p[i].cgr ==null || peoples.p[i+1].p==null)
                a+=0;
                else  a+=1;
            }else {
                if(peoples.p[i].cgr ==Cigar.Blend && peoples.p[i-1].p==Pet.cat)
                a+=0;
                else if(peoples.p[i].cgr ==null || peoples.p[i-1].p==null)
                a+=0;
                else  a+=1;
            }
            //말기르는 사람 - 옆집 던힐
            if(i<4)
            {
                if(peoples.p[i].cgr ==Cigar.Dunhill && peoples.p[i+1].p==Pet.horse)
                a+=0;
                else if(peoples.p[i].cgr ==null || peoples.p[i+1].p==null)
                a+=0;
                else a+=1;
            }else {
                if(peoples.p[i].cgr ==Cigar.Dunhill && peoples.p[i-1].p==Pet.horse)
                a+=0;
                else if(peoples.p[i].cgr ==null || peoples.p[i-1].p==null)
                a+=0;
                else  a+=1;
            }
            //블루매스터 -맥주
            if(peoples.p[i].cgr ==Cigar.Blue_Master && peoples.p[i].b==Beverage.beer)
            a+=0;
            else if(peoples.p[i].cgr ==null || peoples.p[i].b==null)
            a+=0;
            else  a+=1;
            //독일 - 프린스
            if(peoples.p[i].n ==Nationality.German && peoples.p[i].cgr==Cigar.Prince)
            a+=0;
            else if(peoples.p[i].cgr ==null || peoples.p[i].n==null)
            a+=0;
            else  a+=1;
            //블렌드 -옆집 생수
            if(i<4)
            {
                if(peoples.p[i].cgr ==Cigar.Blend && peoples.p[i+1].b==Beverage.water)
                a+=0;
                else if(peoples.p[i].cgr ==null || peoples.p[i+1].b==null)
                a+=0;
                else return false;
            }else 
            {
                if(peoples.p[i].cgr ==Cigar.Blend && peoples.p[i-1].b==Beverage.water)
                a+=0;
                else if(peoples.p[i].cgr ==null || peoples.p[i-1].b==null)
                a+=0;
                else  a+=1;
            }
        }
        if(a==0)
          return true;
        else 
         return false;
    }
   
    

}

