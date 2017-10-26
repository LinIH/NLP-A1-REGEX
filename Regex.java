package ce7024.hw1.s103502004;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(new File("input.txt"));
		FileWriter fw=new FileWriter("output.txt",true);

		String test_str;
		//Pattern pattern = Pattern.compile(".*([0-9]{3,4}( ?(B. C.|A. D.)?) ?- ?[0-9]{3,4} ?(B. C.|A. D.)).*|.*([0123]?[0-9]/(1[012]|0?[1-9])/[0-9]{4}).*|.*(((((1[012]|0?[1-9])/[0123]?[0-9](-(1[012]|0?[1-9])/[0123]?[0-9])?)|((January|April|June|October|Dec.) [0123]?[0-9](-[0123]?[0-9])?))|((1st|2nd|3rd|21st|22nd|23rd|31st|[0123]?[0-9]th) (September|November)))((, ?[0-9]{4}s?| in [0-9]{4}s?)?)|([0-9]{4}s?(-[0-9]{2})?)).*|.*([Ff]rom [0-9]{4}s? to [0-9]{4}s?).*|.*(in (December|April) of [0-9]{4}s?).*");
		Pattern pattern = Pattern.compile("([0-9]{3,4}( ?(B. C.|A. D.)?) ?- ?[0-9]{3,4} ?(B. C.|A. D.))|([0123]?[0-9]/(1[012]|0?[1-9])/[0-9]{4})|(((((1[012]|0?[1-9])/[0123]?[0-9](-(1[012]|0?[1-9])/[0123]?[0-9])?)|((January|Jan.|February|Feb.|March|Mar.|April|Apr.|May|June|Jun.|July|Jul.|August|Aug.|September|Sep.|October|Oct.|November|Nov.|December|Dec.) [0123]?[0-9](-[0123]?[0-9])?))|((1st|2nd|3rd|21st|22nd|23rd|31st|[0123]?[0-9]th) (January|Jan.|February|Feb.|March|Mar.|April|Apr.|May|June|Jun.|July|Jul.|August|Aug.|September|Sep.|October|Oct.|November|Nov.|December|Dec.)))((, ?[0-9]{4}s?| in [0-9]{4}s?)?)|([0-9]{4}s?(-[0-9]{2})?))|([Ff]rom [0-9]{4}s? to [0-9]{4}s?)|(in (January|Jan.|February|Feb.|March|Mar.|April|Apr.|May|June|Jun.|July|Jul.|August|Aug.|September|Sep.|October|Oct.|November|Nov.|December|Dec.) of [0-9]{4}s?)");
		Matcher matcher;

	    final StringBuffer buffer = new StringBuffer();
		
		String replace_str = null;
		while(scan.hasNextLine()){
			test_str = scan.nextLine();
			matcher = pattern.matcher(test_str);
			/*if(matcher.find()){
				replace_str = matcher.replaceAll("<t>" + matcher.group() + "</t>");
				System.out.println(replace_str);
				//fw.write(replace_str);
			}
			else{
				System.out.println(test_str);
				//fw.write(test_str);
			}*/
			while(matcher.find()){
				//replace_str = matcher.replaceAll("<t>" + matcher.group(0) + "</t>");
				replace_str = "<t>"+matcher.group(0)+"</t>";

		        matcher.appendReplacement(buffer, replace_str);
		        //System.out.println(buffer.toString());
		        
			}
	        matcher.appendTail(buffer);
	        fw.write(buffer.toString());
	        buffer.delete(0, buffer.length());
		}
        //System.out.println(buffer.toString());

		scan.close();
		fw.close();
	}

}
