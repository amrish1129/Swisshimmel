package ch.swisshimmel.website.common.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.InternalResourceView;

public class JstlView extends InternalResourceView {
    
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // set original view being asked for as a request parameter
        // Expose the model object as request attributes.
        exposeModelAsRequestAttributes(model,request);

       // Determine the path for the request dispatcher.
       String dispatcherPath = prepareForRendering(request, response);
   
   
        request.setAttribute("body", dispatcherPath.substring(dispatcherPath.lastIndexOf("/") + 1));
 
        //request.setAttribute("partial", prepareForRendering(request, response));
        request.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(request, response);
    }
}