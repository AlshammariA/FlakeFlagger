@Test public void should_ignore_thrown_errors(){
  CloseableStub[] toClose=new CloseableStub[]{new CloseableStub(new IOException("")),new CloseableStub()};
  Closeables.closeQuietly(toClose);
  assertClosed(toClose);
}
