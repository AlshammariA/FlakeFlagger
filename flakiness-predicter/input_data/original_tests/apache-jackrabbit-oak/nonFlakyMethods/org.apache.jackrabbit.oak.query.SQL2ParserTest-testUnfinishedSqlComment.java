@Test(expected=ParseException.class) public void testUnfinishedSqlComment() throws ParseException {
  p.parse("select [jcr:path], [jcr:score], * from [nt:base] as a /* xpath: //* ");
}
