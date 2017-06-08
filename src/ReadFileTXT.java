import java.io.*;

public class ReadFileTXT {
	public static void main(String[] args) {
		
//		 try {  //寫入檔案
//			 FileWriter writer = new FileWriter("Foo123.txt");
//			 writer.write("hello foo!!!");
//			 
//			 writer.close();
//			 System.out.println("writer-close");
//			 
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}	
		
		int start_position = 0; //子字串開始位置
		int end_position = 0; //子字串結束位置
		int counts = 0; //子字串有幾個中文字						
		int position = 0; //子字串的累積長度		
		String line = null;
		int lastStringLength = 17; //最尾端的字串長度
		int stringcounts = 8;  //總共有幾段子字串		
		int[] array = { 3,20,8,8,8,8,50,1}; 	//各段子字串設定的長度
		String Filename = "eDDA_TxFee.txt";
		
		
		try {
			File myFile = new File(Filename);
			InputStreamReader sr = new InputStreamReader(new FileInputStream(myFile),"BIG5");
			BufferedReader reader = new BufferedReader(sr);		
	
			while((line = reader.readLine()) != null){								
				
				if(line.length() <= lastStringLength){
					System.out.println(line + "(最尾端的字串長度=" + line.length() + ")" );
					break;	//跳出while						
				}
				
				for(int i=0; i<stringcounts; i++){
	
					end_position += array[i]; //取得子字串結束位置
					String line01 = line.substring(start_position , end_position);
					
					for (int j = 0; j < array[i]; j++) {
						
						if(position >= array[i]){ //如果發生子字串累積的長度  大於等於  設定的字串長度
							System.out.println("line"+ i +"的長度>="+ array[i] +"大於等於 (累積長度=" + position + ")"	);
							//System.out.println("最上面的位置break");
							break;
						}else if (line01.substring(j, j + 1).matches("[^\\x00-\\xff]")) { //如果沒有，就開始比對有幾個中文或全形字
								  position += 2; //有中文或全形字，位置就+2
								  counts++ ; //有幾個中文或全形字
						      }else{ 
						    	  position++;//沒有中文或全形字，位置就+1
						    	  } 						    	  
						    
						if(position > array[i]){ //檢查完中文字，如果子字串累積的長度  大於  設定的字串長度，便發出警告並中止程式
							System.out.println("**警告**line"+ i +"的長度超出範圍大於"+ array[i] +"(累積長度=" + position + ")"
									+"有"+ counts +"個中文 、全形字"  );
							//System.out.println("中間的位置break");
							break;
						}else if(position == array[i]){ //檢查完中文字，如果子字串累積的長度  等於  設定的字串長度，便抓取正確的字串長度與內容
							//System.out.println("進入 position == stringlength"); 
							end_position = start_position + (j+1);
							//System.out.println("end_position= "+ end_position); 
							line01 = line.substring(start_position , end_position);	
							 
							System.out.println("新的line"+ i +"字串= " + line01 + "(累積長度=" + position + ")"
									+"有"+ counts +"個中文 、全形字");
							//System.out.println("最下面的位置break");
							break;
						}
						
					}//end for
					//System.out.println("small FOR執行完畢");							
					
					position = 0; //子字串的累積長度 >> 歸0
					counts = 0 ; //累計有幾個中文字 >> 歸0
					start_position = end_position;
					if( (i+1) < stringcounts ){
						//System.out.println("(i+1) < stringcounts");
					}else{
						end_position = line.length();
					}
				}//end for
				System.out.println("big FOR執行完畢");
				
				start_position = 0; //子字串開始位置 >> 歸0
				end_position = 0;  //子字串結束位置 >> 歸0
				System.out.println("-----------------------------------");	
	
			} // end while
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}//end main
}//end class
