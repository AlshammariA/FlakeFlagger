@Test public void hashcode(){
  assertEquals(new Handlebars.SafeString("hello").hashCode(),new Handlebars.SafeString("hello").hashCode());
}
