@Test public void center() throws IOException {
  Options options=createMock(Options.class);
  expect(options.hash("size")).andReturn(19);
  expect(options.hash("pad"," ")).andReturn(null);
  replay(options);
  assertEquals("center",center.name());
  assertEquals("  Handlebars.java  ",center.apply("Handlebars.java",options));
  verify(options);
}
