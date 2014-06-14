package gr.sperfect.jukebox.web.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonSongData extends HttpServlet {

	private static final double MAX_PRICE = 100.0; // $100.00
	private static final double MAX_PRICE_CHANGE = 0.02; // +/- 2%

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Random rnd = new Random();

		PrintWriter out = resp.getWriter();
		
		String[] stockSymbols = req.getParameter("q").split(" ");
		String callback = req.getParameter("callback");
		if(callback != null && !callback.isEmpty())
		{
			out.print(callback+"(");		
		}
		
		out.println('[');
		
		boolean firstSymbol = true;
		for (String stockSymbol : stockSymbols) {

			double price = rnd.nextDouble() * MAX_PRICE;
			double change = price * MAX_PRICE_CHANGE
					* (rnd.nextDouble() * 2f - 1f);

			if (firstSymbol) {
				firstSymbol = false;
			} else {
				out.println("  ,");
			}
			out.println("  {");
			out.print("    \"symbol\": \"");
			out.print(stockSymbol);
			out.println("\",");
			out.print("    \"price\": ");
			out.print(price);
			out.println(',');
			out.print("    \"change\": ");
			out.println(change);
			out.println("  }");
		}
		out.println(']');
		
		if(callback != null && !callback.isEmpty())
		{
			out.println(");");
		}
		out.flush();
	}
}
