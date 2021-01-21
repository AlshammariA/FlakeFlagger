@Test public void ljust() throws IOException {
  Options options=createMock(Options.class);
  expect(options.hash("size")).andReturn(20);
  expect(options.hash("pad"," ")).andReturn(null);
  replay(options);
  assertEquals("ljust",ljust.name());
  assertEquals("Handlebars.java     ",ljust.apply("Handlebars.java",options));
  verify(options);
}
