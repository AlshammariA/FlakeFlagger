@Test public void nested(){
  Exception w=null;
  try {
    someMethod();
  }
 catch (  Exception e) {
    w=new Exception("wrapping",e);
  }
  verify(w);
}
