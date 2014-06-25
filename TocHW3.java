Write your basic information in the start of the source code, 
including your name, your student number and brief description of your code.
//蔣承儒, F7400649
/*
用BufferedReader配合InputStreamReader讀入網頁
一行一行比對想尋找的項目
加總後平均，並output
*/

package HW3;

import java.io.*;
import java.net.*;
import java.util.regex.*;

public class TocHW3 {
	static URL url;
	
	public static void main(String[] args) throws IOException {
		String city = "", road_name = "", year = "";
		String input = "", price = "";
		int i, j, sum = 0, counter = 0;
		
		if( args[3].equals("") == false ) {
			url = new URL(args[0]);
			city += args[1];
			road_name += args[2];
			year += args[3];
		} else return;
		
		URLConnection connect = url.openConnection();
		InputStreamReader isr = new InputStreamReader(connect.getInputStream(), "UTF-8");
		BufferedReader buf = new BufferedReader(isr);
		while( (input = buf.readLine()) != null )
			if( input.contains(city) && input.contains(road_name) && 
					input.contains("\"交易年月\":" + year) ) {
				i = input.indexOf("總價元");
				j = input.indexOf("單價每平方公尺");
				price = input.substring( i+5, j-2 );
				sum += Integer.valueOf(price);
				counter++;
				//System.out.println(sum);
			}
		System.out.println(sum/counter);
	}

}
