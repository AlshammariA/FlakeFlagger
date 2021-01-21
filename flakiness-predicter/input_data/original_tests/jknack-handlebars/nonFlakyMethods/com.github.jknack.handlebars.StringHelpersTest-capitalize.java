@Test public void capitalize() throws IOException {
  Options options=createMock(Options.class);
  expect(options.hash("fully",false)).andReturn(false);
  expect(options.hash("fully",false)).andReturn(true);
  replay(options);
  assertEquals("capitalize",capitalize.name());
  assertEquals("Handlebars Java",capitalize.apply("handlebars java",options));
  assertEquals("Handlebars Java",capitalize.apply("HAndleBars JAVA",options));
  verify(options);
}
