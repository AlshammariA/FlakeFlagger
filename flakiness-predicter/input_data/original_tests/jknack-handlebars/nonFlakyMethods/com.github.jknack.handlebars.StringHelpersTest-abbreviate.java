@Test public void abbreviate() throws IOException {
  Options options=createMock(Options.class);
  expect(options.param(0,null)).andReturn(13);
  replay(options);
  assertEquals("abbreviate",abbreviate.name());
  assertEquals("Handlebars...",abbreviate.apply("Handlebars.java",options));
  verify(options);
}
