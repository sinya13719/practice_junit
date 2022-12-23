package junit.exercises.ch20.ex05;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

/**
 * リスト20.5 
 * リクエストパラメータ「name」の値を取得し、「 Hello <nameの値>」という文字列を出力する
 * HelloServletクラスと、そのテストを作成する。なおリクエストはGETのみ対応し、
 * レスポンスのcontent-typeに「text/plain; utf-8」を設定すること
 */
public class HelloServletTest {

    @Test
    public void doGetでリクエストパラメータを含むテキストを出力する() throws Exception {
        // SetUp
        HelloServlet sut = new HelloServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("JUnit");
        ServletOutputStream output = spy(new ServletOutputStream());
        HttpServletResponse response = spy(new HttpServletResponse());
        when(response.getOutputStream()).thenReturn(output);
        // Exercise
        sut.doGet(request, response);
        // Verify
        verify(output).println("Hello JUnit");
        verify(response).setContentType("text/plain; charset=UTF-8");
        verify(response).flushBuffer();
    }

    @Test
    public void doGetでリクエストパラメータを含むテキストを出力する2() throws Exception {
        // SetUp
        HelloServlet sut = new HelloServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("JUnit");
        StringServletOutputStream output = new StringServletOutputStream();
        HttpServletResponse response = spy(new HttpServletResponse());
        when(response.getOutputStream()).thenReturn(output);
        // Exercise
        sut.doGet(request, response);
        // Verify
        assertEquals(output.getOutput(), "Hello JUnit\r\n");
        verify(response).setContentType("text/plain; charset=UTF-8");
        verify(response).flushBuffer();
    }

}