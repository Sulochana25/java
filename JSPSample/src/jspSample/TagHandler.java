package jspSample;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHandler extends TagSupport {
	private static final long serialVersionUID = 1L;

	int count = 5;
	JspWriter out;

	@Override

	public int doStartTag() throws JspException {
		out = pageContext.getOut();
		try {
			out.println("Start of the tags");
		} catch (Exception e) {
			System.out.println(e);
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() {
		out = pageContext.getOut();
		try {
			if (count == 0) {
				out.println("Skip the body now");
				return SKIP_BODY;
			} else {

				out.println("Example for Custom tags");

				count -= 1;
				return EVAL_BODY_AGAIN;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		out = pageContext.getOut();

		try {
			out.println("End of Tag");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}

}
