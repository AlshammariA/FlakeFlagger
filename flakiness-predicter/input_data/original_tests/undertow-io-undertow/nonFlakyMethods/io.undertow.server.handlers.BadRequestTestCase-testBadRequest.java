/** 
 * We send our request manually, as apache HTTP client does not support this.
 * @throws java.io.IOException
 */
@Test public void testBadRequest() throws IOException {
  String request="POST /\r HTTP/1.1\r\nTrailer:foo, bar\r\nTransfer-Encoding: chunked\r\n\r\n9\r\nabcdefghi\r\n0\r\nfoo: fooVal\r\n bar: barVal\r\n\r\n";
  String response1="HTTP/1.1 400 Bad Request\r\nContent-Length: 0\r\nConnection: close\r\n\r\n";
  Socket s=new Socket(DefaultServer.getDefaultServerAddress().getAddress(),DefaultServer.getDefaultServerAddress().getPort());
  try {
    s.getOutputStream().write(request.getBytes());
    StringBuilder sb=new StringBuilder();
    int read=0;
    byte[] buf=new byte[100];
    while (read < response1.length()) {
      int r=s.getInputStream().read(buf);
      if (r <= 0)       break;
      if (r > 0) {
        read+=r;
        sb.append(new String(buf,0,r));
      }
    }
    Assert.assertEquals(response1,sb.toString());
  }
 catch (  IOException expected) {
  }
 finally {
    s.close();
  }
}
