@Test public void testThatBuilderRejectsNullValues(){
  boolean gotException=false;
  try {
    Cookie.builder("",null);
  }
 catch (  NullPointerException nullPointerException) {
    gotException=true;
  }
  assertTrue(gotException);
}
