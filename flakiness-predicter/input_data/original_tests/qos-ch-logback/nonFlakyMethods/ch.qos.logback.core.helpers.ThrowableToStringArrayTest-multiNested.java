@Test public void multiNested(){
  Exception w=null;
  try {
    someOtherMethod();
  }
 catch (  Exception e) {
    w=new Exception("wrapping",e);
  }
  verify(w);
}
