package tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Custom tag, needed for creating links for main page
 * @author Nick
 *
 */
public class JSExecuteTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String jsMain;
	private String jsExecute;
	private String javaHandler;
	private String command;
	private String[] additionalParams;

	public JSExecuteTag() {
	}

	public String getJsMain() {
		return jsMain;
	}

	public void setJsMain(String jsMain) {
		this.jsMain = jsMain;
	}

	public String getJsExecute() {
		return jsExecute;
	}

	public void setJsExecute(String jsExecute) {
		this.jsExecute = jsExecute;
	}

	public String getJavaHandler() {
		return javaHandler;
	}

	public void setJavaHandler(String javaHandler) {
		this.javaHandler = javaHandler;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String[] getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(String[] additionalParams) {
		this.additionalParams = additionalParams;
	}

	public int doStartTag() throws JspException {
		StringBuilder builder = new StringBuilder();
		builder.append(jsMain + "(" + addScopes(javaHandler) + ", " + jsExecute + ", " + addScopes(command));

		if (additionalParams != null) {
			for (int i = 0; i < additionalParams.length; i++) {
				builder.append(",");
				builder.append(addScopes(additionalParams[i]));
			}
		}

		builder.append(")");
		try {
			pageContext.getOut().write("<a href = '#' onclick = \"" + builder.toString() + "\"" + ">");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().write("</a>");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}

	private String addScopes(String input) {
		return "'" + input + "'";
	}
}
