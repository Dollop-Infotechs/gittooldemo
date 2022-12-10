class NumberConversion
{
    public String intToBinaryString(int num){
      String s="";
      boolean nigative = false;
      if(num < 0)
      {
          nigative = true;
          num = num*-1;
      }
      while(num!=0){
        s =  (num % 2)+s;
        num /=2;
      }

      if(nigative==true)
        return onesAndTwos(s);

      return s;
    }
    public String onesAndTwos(String bin){
        String s = "00000000000000000000000000000000";
        int carry=1;

        s = s.substring(0,s.length()-bin.length())+bin;


        char ch[] = s.toCharArray();

        for(int i=ch.length-1;i>=0;i--)
        {
          ch[i] = ch[i]=='0'?'1':'0';   


          if(ch[i]=='1' && carry == 1)
               ch[i]='0';
          else if(carry == 1)
          {
               carry = 0;
               ch[i]='1';
          }

        }
        return new String(ch);
    }

    public int pow(int n,int p)
    {
        int s=1;
        while(p>=1){
          s=s*n;
          p--;
        }
        return s;
    }

    public int binToInt(String bin)
    {
        int n = 0,j=0;
        for(int i=bin.length()-1;i>=0;i--)
        {
          n = n + (bin.charAt(i)-48) * pow(2,j++);
        }
        return n;
    }
    public void binToOct(String bin)
    {
        int l = bin.length();
        String n="";
        for(int i=bin.length()/3;i>0;i--)
        {
            n=binToInt(bin.substring(l-3,l))+n;
            
           l=l-3;
        }
        if(l>0)
        {
           n=binToInt(bin.substring(0,l))+n;           
        }

        System.out.println(n);
    }
    public void binToHexa(String bin)
    {
         int l = bin.length();
        String n="";
        for(int i=bin.length()/4;i>0;i--)
        {
            n=binToInt(bin.substring(l-4,l))+" "+n;
            
           l=l-4;
        }
        if(l>0)
        {
           n=binToInt(bin.substring(0,l))+" "+n;           
        }

        System.out.println(n);
    }
    
}

class Test
{ 
    // public static void main(String[] args)
    public static void main(String[] args) {

      NumberConversion nc = new NumberConversion();
      String s = nc.intToBinaryString(100);
      

      //nc.binToInt(s); 
       // nc.binToOct(s);
      nc.binToHexa(s);
      
    }
  
}
