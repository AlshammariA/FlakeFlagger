@Test public void shouldReturnCorrectFormatterByName(){
  assertEquals(FormatterType.LINT,FormatterType.getByFormat("lint-xml"));
  assertEquals(FormatterType.CSSLINT,FormatterType.getByFormat("csslint-xml"));
  assertEquals(FormatterType.CHECKSTYLE,FormatterType.getByFormat("checkstyle-xml"));
  assertEquals(null,FormatterType.getByFormat("INVALID"));
}
