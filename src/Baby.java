
public class Baby {
  String name=null;
  public Baby(){
    name="Baby";
  }
  public Baby(String s){
    name=s;
  }
  public void setName(String s){
    name=s;
  }
  
  
  public static void main(String[] args){
    Baby b1=new Baby();  //一開始就指定
    System.out.println(b1.name);//生了一個小孩，名子先叫baby
    
    Baby b2=new Baby("MIMI"); //傳值進去
    System.out.println(b2.name);//再生一個小孩，乳名叫MIMI
    
    b1.setName("PPPP"); //用method指定
    System.out.println(b1.name);//幫老大取名為Alex
    
    b2.setName("ZZZZ");//用method指定
    System.out.println(b2.name);//老二取名為mary
  }
  
}