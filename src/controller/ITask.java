package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Task interface
 * @author Nick
 *
 */
public interface ITask {
	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
