package controller;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Class, needed for reading response for ajax
 * @author Nick
 *
 */
public class CharArrayWriterResponse extends HttpServletResponseWrapper {

	private final CharArrayWriter charArray = new CharArrayWriter();

	public CharArrayWriterResponse(HttpServletResponse response) {
		super(response);
	}

	public PrintWriter getWriter() throws IOException {
		return new PrintWriter(charArray);
	}

	public String getOutput() {
		return charArray.toString();
	}
}