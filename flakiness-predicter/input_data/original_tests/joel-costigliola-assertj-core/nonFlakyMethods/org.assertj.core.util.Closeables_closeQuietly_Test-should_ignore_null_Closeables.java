@Test public void should_ignore_null_Closeables(){
  CloseableStub c=new CloseableStub();
  CloseableStub[] toClose=new CloseableStub[]{null,c};
  Closeables.closeQuietly(toClose);
  assertClosed(c);
}
