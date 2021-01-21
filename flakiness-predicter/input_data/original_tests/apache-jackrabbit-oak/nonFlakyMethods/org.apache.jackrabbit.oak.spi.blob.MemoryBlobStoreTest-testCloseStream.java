@Test public void testCloseStream() throws Exception {
  final AtomicBoolean closed=new AtomicBoolean();
  InputStream in=new InputStream(){
    @Override public void close(){
      closed.set(true);
    }
    @Override public int read() throws IOException {
      return -1;
    }
  }
;
  store.writeBlob(in);
  assertTrue(closed.get());
}
