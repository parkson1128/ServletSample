

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ReadFile
 */
@WebServlet(
		urlPatterns = { "/ReadFile" }, 
		initParams = { 
				@WebInitParam(name = "default456", value = "this is a default value456")
		})
public class ReadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("(ReadFile)開始執行doPost-servlet"); 
//		String connectionURL="jdbc:db2://192.168.114.128:50000/CSHIBANK";
//		String username="administrator";
//		String password="25082201";
		
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
			// System.out.println("HelloWorld��憪��瑁�鞈���摨�"); 
			 
			 String value =  request.getParameter("value");
			 System.out.println("(ReadFile)from servlet print-");
			 System.out.println("(ReadFile)value from JSP=" + value);
			 System.out.println("\n");
			 
			 //PrintWriter out = response.getWriter();
			 //System.out.println("HelloWorld��憪��瑁����蛋SP"); 
			 //out.println("from servlet9999");
			 
			 //String test02 ="MEMBER_ID= \n";
/*			 try {  //寫入檔案
				 FileWriter writer = new FileWriter("Foo.txt");
				 writer.write("hello foo!!!");
				 
				 writer.close();
				 System.out.println("writer-close");
				 
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
*/
			 
			 
			 
//eDDA_TxFee.txt

					 try {
							File myFile = new File("eDDA_TxFee.txt");
							InputStreamReader sr = new InputStreamReader(new FileInputStream(myFile),"BIG5");
							BufferedReader reader = new BufferedReader(sr);
							
							String line = null;
		
							while((line = reader.readLine()) != null){
								
								int stringcounts = 8;  //總共有幾段子字串
								int start_position = 0; //子字串開始位置
								int end_position = 0; //子字串結束位置
								int counts = 0; //子字串有幾個中文字						
								int position = 0; //子字串的累積長度
								int lastStringLength = 17; //最尾端的字串長度
								
								int[] array = { 3,20,8,8,8,8,50,1};	//各段子字串設定的長度					
								
								if(line.length() <= lastStringLength){
									System.out.println(line + "(最尾端的字串長度=" + line.length() + ")" );
									break;	//跳出while						
								}
								
								for(int i=0; i<stringcounts; i++){
		
									end_position += array[i]; //取得結束位置
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
									
									position = 0; //子字串的累積長度>> 歸0
									counts = 0 ; //累計有幾個中文字>> 歸0
									start_position = end_position;
									if( (i+1) < stringcounts ){
										//System.out.println("(i+1) < stringcounts");
									}else{
										end_position = line.length();
									}
								}//end for
							//	System.out.println("big FOR執行完畢");
								
								System.out.println("-----------------------------------");	
					
							} // end while
							reader.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
			 
			 
			 
/*			 
//eDDA_CreditorList.txt			 
			 try {
					File myFile = new File("eDDA_CreditorList.txt");
					InputStreamReader sr = new InputStreamReader(new FileInputStream(myFile),"BIG5");
					BufferedReader reader = new BufferedReader(sr);
					
					String line = null;

					while((line = reader.readLine()) != null){
						int stringcounts = 15;  //總共有幾段子字串
						int start_position = 0; //子字串開始位置
						int end_position = 0; //子字串結束位置
						int counts = 0; //子字串有幾個中文字						
						int position = 0; //子字串的累積長度
						int lastStringLength = 17; //最尾端的字串長度
						int[] array = { 10, 8, 140, 3, 20, 7, 30, 30, 8, 8, 8, 1, 1, 1, 1};
						
						
						
						if(line.length() <= lastStringLength){
							System.out.println(line + "(最尾端的字串長度=" + line.length() + ")" );
							break;	//跳出while						
						}
						
						for(int i=0; i<stringcounts; i++){

							end_position += array[i]; //取得結束位置
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
							
							position = 0; //子字串的累積長度>> 歸0
							counts = 0 ; //累計有幾個中文字>> 歸0
							start_position = end_position;
							if( (i+1) < stringcounts ){
								//System.out.println("(i+1) < stringcounts");
							}else{
								end_position = line.length();
							}
						}//end for
					//	System.out.println("big FOR執行完畢");
						
						System.out.println("-----------------------------------");	
			
					} // end while
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
*/			 
			 
			 
/*			//eDDA_CreditorList.txt	備份		 
			 try {
					File myFile = new File("eDDA_CreditorList.txt");
					InputStreamReader sr = new InputStreamReader(new FileInputStream(myFile),"BIG5");
					BufferedReader reader = new BufferedReader(sr);
					
					String line = null;

					while((line = reader.readLine()) != null){
						
						if(line.length() <= 17){
							System.out.println(line + "(最尾端的字串長度=" + line.length() + ")" );
							break;							
						}
												
						String line01 = line.substring(0 , 10);
						String line02 = line.substring(10 , 18);
						System.out.println(line02 + "(原本的line02長度=" + line02.length() + ")");
						
						//line02字串，長度校正
						int counts = 0;
						int counts02 = 0;
						
					    for (int i = 0; i < line02.length(); i++) {
					      if (line02.substring(i, i + 1).matches("[^\\x00-\\xff]")) {
					        counts++;
					      }
					    }
					    
					    
					    //判斷line02 正確該減幾個中文字
					    if(counts == 8){
					    	line02 = line.substring(10 , 18-(counts/2));
					    }else if(counts < 8 && counts >0) {
					    	
					    	int halfcounts = 0;
						    line02 = line.substring(10 , 14);					   
						    for (int i = 0; i < line02.length(); i++) {
						    	if (line02.substring(i, i + 1).matches("[^\\x00-\\xff]")) {
						    		halfcounts++;
						    	}
						    }  
						    if(halfcounts == 4) {
						    	line02 = line.substring(10 , 14);
						    }else if(halfcounts == 3){
						    	line02 = line.substring(10 , 15);
						    }else if(halfcounts == 2){
						    	line02 = line.substring(10 , 16);
						    }else if(halfcounts == 1){
						    	line02 = line.substring(10 , 16);
						    }
							
						}else if(counts == 0) {
							line02 = line.substring(10 , 18-counts);
						}
						    
						
					    
					    	
					    
					    
					    
					    counts02 = counts;
					    System.out.println("(line02-counts長度=" + counts + ")");
					    System.out.println(line02 + "(新的line02長度=" + line02.length() + ")");
					    
					    String line03 = line.substring( 18-counts , 158-counts);
					    
					    //line03字串，長度校正
						
					    for (int i = 0; i < line03.length(); i++) {
					      if (line03.substring(i, i + 1).matches("[^\\x00-\\xff]")) {
					        counts++;
					      }
					    }					    
					    line03 = line.substring(18-counts , 158-counts);
					    
						String line04 = line.substring(158-counts , 161-counts);
						String line05 = line.substring(161-counts , 181-counts);
						
						//line05字串，長度校正
						
					    for (int i = 0; i < line05.length(); i++) {
					      if (line05.substring(i, i + 1).matches("[^\\x00-\\xff]")) {
					        counts++;
					      }
					    }					    
					    line05 = line.substring(161-counts , 181-counts);
						
					    String line06 = line.substring(181-counts , 188-counts);						
						String line07 = line.substring(188-counts , 218-counts);
						//line07字串，長度校正
						//int counts02 = 0;
					    for (int i = 0; i < line07.length(); i++) {
					      if (line07.substring(i, i + 1).matches("[^\\x00-\\xff]")) {
					        counts++;
					      }
					    }
					    line07 = line.substring(188-counts , 218-counts);
					    
						String line08 = line.substring(218-counts , 248-counts);
						
						//line08字串，長度校正
						
					    for (int i = 0; i < line08.length(); i++) {
					      if (line08.substring(i, i + 1).matches("[^\\x00-\\xff]")) {
					        counts++;
					      }
					    }					    
					    line08 = line.substring(218-counts , 248-counts);
						
						String line09 = line.substring(248-counts , 256-counts);
						String line10 = line.substring(256-counts , 264-counts);
						String line11 = line.substring(264-counts , 272-counts);
						String line12 = line.substring(272-counts , 273-counts);
						String line13 = line.substring(273-counts , 274-counts);
						String line14 = line.substring(274-counts , 275-counts);
						String line15 = line.substring(275-counts , line.length());

						System.out.println(line + "(原本的字串長度=" + line.length() + ")" );
						System.out.println(line01 + "(長度=" + line01.length() + ")");
						System.out.println(line02 + "(長度=" + line02.length() + ")" + "中文 、全形所佔長度  = " + counts02);
						System.out.println(line03 + "(長度=" + line03.length() + ")" + "中文 、全形所佔長度  = " + counts02);
						System.out.println(line04 + "(長度=" + line04.length() + ")");
						System.out.println(line05 + "(長度=" + line05.length() + ")" + "中文 、全形所佔長度  = " + counts02);
						System.out.println(line06 + "(長度=" + line06.length() + ")");
						System.out.println(line07 + "(長度=" + line07.length() + ")" + "中文 、全形所佔長度  = " + counts02);
						System.out.println(line08 + "(長度=" + line08.length() + ")" + "中文 、全形所佔長度  = " + counts02);
						System.out.println(line09 + "(長度=" + line09.length() + ")");
						System.out.println(line10 + "(長度=" + line10.length() + ")");
						System.out.println(line11 + "(長度=" + line11.length() + ")");
						System.out.println(line12 + "(長度=" + line12.length() + ")");
						System.out.println(line13 + "(長度=" + line13.length() + ")");
						System.out.println(line14 + "(長度=" + line14.length() + ")");
						System.out.println(line15 + "(長度=" + line15.length() + ")");						
						System.out.println("-----------------------------------");
						
					} // end while
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
*/
/*			 
//eDDA_TxFee.txt			 
			 try {
					File myFile = new File("eDDA_TxFee.txt");
					InputStreamReader sr = new InputStreamReader(new FileInputStream(myFile),"BIG5");
					BufferedReader reader = new BufferedReader(sr);
					
					String line = null;

					while((line = reader.readLine()) != null){
						
						if(line.length() <= 17){
							System.out.println(line + "(最尾端的字串長度=" + line.length() + ")" );
							break;							
						}
												
						String line01 = line.substring(0 , 3);
						String line02 = line.substring(3 , 23);
						//System.out.println(line02 + "(原本的line02長度=" + line02.length() + ")");
						
						//line02字串，長度校正
						int counts = 0;
					    for (int i = 0; i < line02.length(); i++) {
					      if (line02.substring(i, i + 1).matches("[^\\x00-\\xff]")) {
					        counts++;
					      }
					    }					    
					    line02 = line.substring(3 , 23-counts);
					    //System.out.println(line02 + "(新的line02長度=" + line02.length() + ")");
					    
					    String line03 = line.substring(23-counts , 31-counts);
						String line04 = line.substring(31-counts , 39-counts);
						String line05 = line.substring(39-counts , 47-counts);
					    String line06 = line.substring(47-counts , 55-counts);						
						String line07 = line.substring(55-counts , 105-counts);
						//line07字串，長度校正
						int counts02 = 0;
					    for (int i = 0; i < line07.length(); i++) {
					      if (line07.substring(i, i + 1).matches("[^\\x00-\\xff]")) {
					        counts02++;
					      }
					    }

					    line07 = line.substring(55-counts , 105-counts-counts02);
						String line08 = line.substring(105-counts-counts02 , line.length());
						

						System.out.println(line + "(原本的字串長度=" + line.length() + ")" );
						System.out.println(line01 + "(長度=" + line01.length() + ")");
						System.out.println(line02 + "(長度=" + line02.length() + ")" + "中文 、全形所佔長度  = " + counts);
						System.out.println(line03 + "(長度=" + line03.length() + ")");
						System.out.println(line04 + "(長度=" + line04.length() + ")");
						System.out.println(line05 + "(長度=" + line05.length() + ")");
						System.out.println(line06 + "(長度=" + line06.length() + ")");
						System.out.println(line07 + "(長度=" + line07.length() + ")" + "中文 、全形所佔長度  = " + counts02);
						System.out.println(line08 + "(長度=" + line08.length() + ")");						
						System.out.println("-----------------------------------");
						
					} // end while
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}	
*/
			 
			 
/*			 
//eDDA_SDBankList.txt			 
			 try {
					File myFile = new File("eDDA_SDBankList.txt");
					InputStreamReader sr = new InputStreamReader(new FileInputStream(myFile),"BIG5");
					BufferedReader reader = new BufferedReader(sr);
					
					String line = null;

					while((line = reader.readLine()) != null){

						String line01 = line.substring(0 , 7);
						String line02 = line.substring(7 , 14);
						String line03 = line.substring(14 , line.length());
						
						System.out.println(line + "(原本的字串長度=" + line.length() + ")" );
						System.out.println(line01 + "(長度=" + line01.length() + ")");
						System.out.println(line02 + "(長度=" + line02.length() + ")");
						System.out.println(line03 + "(長度=" + line03.length() + ")");
						System.out.println("-----------------------------------");
						
					}
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			 
*/			 
/*
//eDDA_ReplyCode.txt			 
			 try {
					File myFile = new File("eDDA_ReplyCode.txt");
					InputStreamReader sr = new InputStreamReader(new FileInputStream(myFile),"BIG5");
					BufferedReader reader = new BufferedReader(sr);
					
					String line = null;

					while((line = reader.readLine()) != null){

						String line01 = line.substring(0 , 2);
						String line02 = line.substring(2 , line.length());
						
						System.out.println(line + "(原本的字串長度=" + line.length() + ")" );
						System.out.println(line01 + "(長度=" + line01.length() + ")");
						System.out.println(line02 + "(長度=" + line02.length() + ")");
						System.out.println("-----------------------------------");
						
					}
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		 
*/			 
			 
//eDDA_BGBankList
/*	try {
					File myFile = new File("eDDA_BGBankList.txt");					
					InputStreamReader sr = new InputStreamReader(new FileInputStream(myFile),"BIG5");
					BufferedReader reader = new BufferedReader(sr);
					
					String line = null;

					while((line = reader.readLine()) != null){
						
						String line01 = line.substring(0 , 7);
						String line02 = line.substring(7 , line.length());						
						
						System.out.println(line + "(原本的字串長度=" + line.length() + ")" );						
						System.out.println(line01 + "(長度=" + line01.length() + ")");						
						System.out.println(line02 + "(長度=" + line02.length() + ")");
						System.out.println("-----------------------------------");

					}
					
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();					
				}

*/

			 
	} //end dopost
} //end class
