@Test public void rjust() throws IOException {
  Options options=createMock(Options.class);
  expect(options.hash("size")).andReturn(20);
  expect(options.hash("pad"," ")).andReturn(null);
  replay(options);
  assertEquals("rjust",rjust.name());
  assertEquals("     Handlebars.java",rjust.apply("Handlebars.java",options));
  verify(options);
}
