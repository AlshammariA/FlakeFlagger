@Test public void testIgnoreSqlComment() throws ParseException {
  p.parse("select * from [nt:unstructured] /* sql comment */");
  p.parse("select [jcr:path], [jcr:score], * from [nt:base] as a /* xpath: //* */");
}
