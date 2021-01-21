@Test public void testToJsMultilineString(){
  assertEquals("[\"\\n\"].join(\"\\n\")",WroUtil.toJSMultiLineString(""));
  assertEquals("[\"alert1\\n\"].join(\"\\n\")",WroUtil.toJSMultiLineString("alert1"));
  assertEquals("[\"\",\"alert1\",\"alert2\"].join(\"\\n\")",WroUtil.toJSMultiLineString("\nalert1\nalert2"));
}
