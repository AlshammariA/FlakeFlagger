@Test public void smoke(){
  String contextType="text/html";
  assertTrue(ContentTypeUtil.isTextual(contextType));
  assertEquals("html",ContentTypeUtil.getSubType(contextType));
}
