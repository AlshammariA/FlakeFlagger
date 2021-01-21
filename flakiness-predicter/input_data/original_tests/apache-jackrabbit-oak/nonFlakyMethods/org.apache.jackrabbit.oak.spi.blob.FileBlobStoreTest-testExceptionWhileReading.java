@Test public void testExceptionWhileReading() throws Exception {
  final AtomicBoolean closed=new AtomicBoolean();
  InputStream in=new InputStream(){
    @Override public void close(){
      closed.set(true);
    }
    @Override public int read() throws IOException {
      throw new RuntimeException("abc");
    }
  }
;
  try {
    store.writeBlob(in);
  }
 catch (  Exception e) {
    String msg=e.getMessage();
    assertTrue(msg,msg.indexOf("abc") >= 0);
  }
  assertTrue(closed.get());
}
