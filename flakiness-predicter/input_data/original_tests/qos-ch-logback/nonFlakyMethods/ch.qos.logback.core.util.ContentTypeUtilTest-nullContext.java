@Test public void nullContext(){
  String contextType=null;
  assertFalse(ContentTypeUtil.isTextual(contextType));
  assertNull(ContentTypeUtil.getSubType(contextType));
}
