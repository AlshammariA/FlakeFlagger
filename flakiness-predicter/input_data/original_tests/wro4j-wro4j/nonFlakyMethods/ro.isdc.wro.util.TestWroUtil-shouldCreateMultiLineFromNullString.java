@Test public void shouldCreateMultiLineFromNullString(){
  assertEquals("[].join(\"\\n\")",WroUtil.toJSMultiLineString(null));
}
