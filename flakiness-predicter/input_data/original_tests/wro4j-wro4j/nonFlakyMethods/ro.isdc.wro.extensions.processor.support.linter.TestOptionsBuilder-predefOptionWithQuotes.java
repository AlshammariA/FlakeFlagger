@Test public void predefOptionWithQuotes() throws Exception {
  assertEquals("{\"predef\": \"['YUI']\"}",optionsBuilder.build("predef=\"['YUI']\""));
}
