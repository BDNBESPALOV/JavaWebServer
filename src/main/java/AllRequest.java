import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AllRequest extends HttpServlet {
    public void doGet(HttpServletRequest request/*запрос*/, HttpServletResponse response/*ответ*/) throws IOException {
        Map<String,Object> pageVariables = createPageVariablesMap(request);
        pageVariables.put("message", "");
        response.getWriter().println(PageGenerator.instance().getPage("page.html",pageVariables));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> pageVareables = createPageVariablesMap(request);
        String message = request.getParameter("message");
        response.setContentType("text/html;charset=utf-8");
        if (message == null || message.isEmpty()){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            pageVareables.put("message", message == null ? "" : message);
            response.getWriter().println(PageGenerator.instance().getPage("page.html",pageVareables));
        }

    }

    private static Map<String,Object> createPageVariablesMap(HttpServletRequest request){
        Map<String,Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL",request.getRequestURI().toString());
        pageVariables.put("pathInfo",request.getPathInfo());
        pageVariables.put("sessionId",request.getSession().getId());
        pageVariables.put("parameters",request.getParameterMap().toString());
        return pageVariables;
    }
}
