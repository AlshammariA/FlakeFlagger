@Test public void should_close_Closeables(){
  CloseableStub[] toClose=new CloseableStub[]{new CloseableStub(),new CloseableStub()};
  Closeables.closeQuietly(toClose);
  assertClosed(toClose);
}
