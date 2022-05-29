import enums.*;
public class backtracking {
    public static void main(String[] args) {
        
        People[] p= new People[5];
        Peoples peoples=new Peoples();
        int result=0;
    
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

    public static boolean result(Peoples peoples)
    {
        int re=0;
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
    }

    public static void back(Peoples peoples)
    {
        Peoples u;

        if(promising(peoples))
        {
            //25개 꽉찬 상태라면 출력 
            if(result(peoples)){
                print_result(peoples.p);
            }
        }else 
        {//자식으로 이동

        }

    }
    public static boolean promising(Peoples peoples) {
        for(int i=0;i<5;i++)
        {
            //영국인은 빨간집에 산다.
            if((peoples.p[i].c==Color.red&&peoples.p[i].n!=Nationality.Brit)||
               (peoples.p[i].c!=Color.red||peoples.p[i].p!=null &&peoples.p[i].n==Nationality.Brit))
            {
                return false;
            }
            
            //스웨덴인 개를 기른다.
            if((peoples.p[i].n==Nationality.Swede && (peoples.p[i].p!=Pet.dog||peoples.p[i].p!=null))||
               (peoples.p[i].n!=Nationality.Swede||peoples.p[i].p!=null && (peoples.p[i].p==Pet.dog)))
            {
                return false;
            }
            
            //덴마크 사람은 차를 마신다.
            if((  peoples.p[i].n==Nationality.Dane && (peoples.p[i].b!=Beverage.tea||peoples.p[i].b!=null))
            ||(  peoples.p[i].n!=Nationality.Dane||peoples.p[i].n!=null &&peoples.p[i].b==Beverage.tea))
            {
                return false;
            }
            
            //초록색 집은 하얀집의 왼쪽집이다.
            if(i!=4){
                if((peoples.p[i].c==Color.green&&peoples.p[i+1].c!=Color.white)
                ||(peoples.p[i].c!=Color.green||peoples.p[i].c!=null &&peoples.p[i+1].c==Color.white))
                {
                    return false;
                }
            }
            //초록집에 사는 사람은 커피를 마심
            if((peoples.p[i].b==Beverage.coffee&&(peoples.p[i].c!=Color.green||peoples.p[i].c!=null))
            ||((peoples.p[i].b==Beverage.coffee||peoples.p[i].b!=null)&&peoples.p[i].c!=Color.green))
            {
                return false;
            }
            //펠몰 담배 -새
            if(peoples.p[i].cgr==Cigar.Pall_Mall&&peoples.p[i].p==Pet.bird)
            {
                continue;
            }else if(peoples.p[i].cgr==null||peoples.p[i].p==null)
            {
                continue;
            }else {return false;
            //노란집 - 던힐
            if(peoples.p[i].c ==Color.yellow && peoples.p[i].cgr ==Cigar.Dunhill)
            {
                continue;
            }else if(peoples.p[i].c ==null || peoples.p[i].cgr ==null)
            {
                continue;
            } else return false;
            //블렌드 담배 -옆집 고양이 키움
            if(i<4)
            {
                if(peoples.p[i].cgr ==Cigar.Blend && peoples.p[i+1].p==Pet.cat)
                continue;
                else if(peoples.p[i].cgr ==null || peoples.p[i+1].p==null)
                continue;
                else return false;
            }else {
                if(peoples.p[i].cgr ==Cigar.Blend && peoples.p[i-1].p==Pet.cat)
                continue;
                else if(peoples.p[i].cgr ==null || peoples.p[i-1].p==null)
                continue;
                else return false;
            }
            //말기르는 사람 - 옆집 던힐
            if(i<4)
            {
                if(peoples.p[i].cgr ==Cigar.Dunhill && peoples.p[i+1].p==Pet.horse)
                continue;
                else if(peoples.p[i].cgr ==null || peoples.p[i+1].p==null)
                continue;
                else return false;
            }else {
                if(peoples.p[i].cgr ==Cigar.Dunhill && peoples.p[i-1].p==Pet.horse)
                continue;
                else if(peoples.p[i].cgr ==null || peoples.p[i-1].p==null)
                continue;
                else return false;
            }
            //블루매스터 -맥주
            if(peoples.p[i].cgr ==Cigar.Blue_Master && peoples.p[i].b==Beverage.beer)
            continue;
            else if(peoples.p[i].cgr ==null || peoples.p[i].b==null)
            continue;
            else return false;
            //독일 - 프린스
            if(peoples.p[i].n ==Nationality.German && peoples.p[i].cgr==Cigar.Prince)
            continue;
            else if(peoples.p[i].cgr ==null || peoples.p[i].n==null)
                continue;
            else return false;
            //블렌드 -옆집 생수
            if(i<4)
            {
                if(peoples.p[i].cgr ==Cigar.Blend && peoples.p[i+1].b==Beverage.water)
                    continue;
                else if(peoples.p[i].cgr ==null || peoples.p[i+1].b==null)
                    continue;
                else return false;
            }else {
                if(peoples.p[i].cgr ==Cigar.Blend && peoples.p[i-1].b==Beverage.water)
                    continue;
                else if(peoples.p[i].cgr ==null || peoples.p[i-1].b==null)
                    continue;
                else return false;
            }
        }
        return true;
    }
   
    

}

