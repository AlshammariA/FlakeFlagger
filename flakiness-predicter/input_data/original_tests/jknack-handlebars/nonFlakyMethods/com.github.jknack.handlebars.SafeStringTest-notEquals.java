@Test public void notEquals(){
  assertNotSame(new Handlebars.SafeString("hello"),new Handlebars.SafeString("hello!"));
}
