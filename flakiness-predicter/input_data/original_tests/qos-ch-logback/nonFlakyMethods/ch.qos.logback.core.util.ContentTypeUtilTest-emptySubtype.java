@Test public void emptySubtype(){
  String contextType="text/";
  assertTrue(ContentTypeUtil.isTextual(contextType));
  assertNull(ContentTypeUtil.getSubType(contextType));
}
