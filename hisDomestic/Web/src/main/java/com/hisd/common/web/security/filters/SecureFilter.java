package com.hisd.common.web.security.filters;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hisd.common.utility.SendMessageUtil;

@Component
public class SecureFilter extends OncePerRequestFilter {

    public SecureFilter() {
    }
    private SessionFactory sessionFactory;
    private SendMessageUtil sendMessageUtil;
    private List<String> skipFilterPages;
    private String mailTo;
    private boolean sendMail;
	private String contextName;

    public SecureFilter(SessionFactory sessionFactory, String mailTo, List<String> skipFilterPages,boolean sendMail,String contextName) {
        this.sessionFactory = sessionFactory;
        /*this.sendMessageUtil = sendMessageUtil1;*/
        this.mailTo = mailTo;
        this.skipFilterPages = skipFilterPages;
        this.sendMail = sendMail;
        this.contextName = contextName;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
    	
    	int langId = 1;
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("X-Frame-Options", "SAMEORIGIN");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
                
        String ae = request.getHeader("accept-encoding");
    	if(!request.getRequestURI().contains("/"+contextName+"/resources") && langId==0 && !request.getRequestURL().toString().endsWith("pagenotfound")){
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/pagenotfound"));
        }else{
            if (ae != null && ae.indexOf("gzip") != -1) {
                GZIPResponseWrapper wrappedResponse = new GZIPResponseWrapper(response);
                chain.doFilter(request, wrappedResponse);
                wrappedResponse.finishResponse();
            } else {
                chain.doFilter(request, response);
            }
        }
    }

     static class GZIPResponseWrapper extends HttpServletResponseWrapper {

        protected HttpServletResponse origResponse = null;
        protected ServletOutputStream stream = null;
        protected PrintWriter writer = null;

        public GZIPResponseWrapper(HttpServletResponse response) {
            super(response);
            origResponse = response;
        }

        public ServletOutputStream createOutputStream() throws IOException {
            return (new GZIPResponseStream(origResponse));
        }

        public void finishResponse() {
            try {
                if (writer != null) {
                    writer.close();
                } else {
                    if (stream != null) {
                        stream.close();
                    }
                }
            } catch (IOException e) {
            }
        }

        @Override
        public void flushBuffer() throws IOException {
            stream.flush();
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            if (writer != null) {
                throw new IllegalStateException("getWriter() has already been called!");
            }

            if (stream == null) {
                stream = createOutputStream();
            }
            return (stream);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            if (writer != null) {
                return (writer);
            }

            if (stream != null) {
                throw new IllegalStateException("getOutputStream() has already been called!");
            }

            stream = createOutputStream();
            writer = new PrintWriter(new OutputStreamWriter(stream, "UTF-8"));
            return (writer);
        }

        @Override
        public void setContentLength(int length) {
        }
    }

    static class GZIPResponseStream extends ServletOutputStream {

        protected ByteArrayOutputStream baos = null;
        protected GZIPOutputStream gzipstream = null;
        protected boolean closed = false;
        protected HttpServletResponse response = null;
        protected ServletOutputStream output = null;

        public GZIPResponseStream(HttpServletResponse response) throws IOException {
            super();
            closed = false;
            this.response = response;
            this.output = response.getOutputStream();
            baos = new ByteArrayOutputStream();
            gzipstream = new GZIPOutputStream(baos);
        }

        @Override
        public void close() throws IOException {
            if (closed) {
                throw new IOException("This output stream has already been closed");
            }
            gzipstream.finish();

            byte[] bytes = baos.toByteArray();


            response.addHeader("Content-Length",
                    Integer.toString(bytes.length));
            response.addHeader("Content-Encoding", "gzip");
            output.write(bytes);
            output.flush();
            output.close();
            closed = true;
        }

        @Override
        public void flush() throws IOException {
            gzipstream.flush();
        }

        @Override
        public void write(int b) throws IOException {
            if (closed) {
                throw new IOException("Cannot write to a closed output stream");
            }
            gzipstream.write((byte) b);
        }

        @Override
        public void write(byte b[]) throws IOException {
            write(b, 0, b.length);
        }

        @Override
        public void write(byte b[], int off, int len) throws IOException {
            if (closed) {
                throw new IOException("Cannot write to a closed output stream");
            }
            gzipstream.write(b, off, len);
        }

        public boolean closed() {
            return (this.closed);
        }

        public void reset() {
            //noop
        }
    }

    
    private boolean isPageSkipped(String uri) {
        boolean pageSkipped = false;

        if (uri.contains("/"+contextName+"/resources")) {
            pageSkipped = true;
        } else {
            for (String str : skipFilterPages) {
                if (uri.endsWith(str)) {
                    pageSkipped = true;
                    break;
                }
            }
        }
        return pageSkipped;
    }
}
