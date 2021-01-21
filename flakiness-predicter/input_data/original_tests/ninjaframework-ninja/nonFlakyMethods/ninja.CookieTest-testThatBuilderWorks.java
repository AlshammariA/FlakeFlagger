@Test public void testThatBuilderWorks(){
  Cookie cookie=Cookie.builder("key","value").build();
  assertEquals("key",cookie.getName());
  assertEquals("value",cookie.getValue());
  assertEquals(-1,cookie.getMaxAge());
  assertEquals("/",cookie.getPath());
}
