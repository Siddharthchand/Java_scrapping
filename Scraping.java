package daily_coding;
//import java.util.*;
import java.io.*;
import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Scraping 
{
	public static void main(String[] args) throws IOException
	{
		Document doc = Jsoup.connect("https://www.imdb.com/list/ls066033834/").get();
		Elements e=doc.select("h3.lister-item-header");
		System.out.println("Scraping the top 20 highest imdb rated movies of all time");
		System.out.println("MOVIE NAME :");
		System.out.println();
		String s1="";
		for(Element i:e)
		{
			//System.out.println(i.getElementsByTag("a").text());
			s1=s1+i.getElementsByTag("a").text()+"\n"; // scraping the movie names from the website one by one
		}
			FileWriter fWriter = new FileWriter("C:\\Users\\HP\\Downloads\\Top 20 Imdb Movies.text"); // creating file to store the scrapped result
            fWriter.write(s1);
            System.out.println(s1);
            fWriter.close();
	}
}