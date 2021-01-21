@Test public void ljustWithPad() throws IOException {
  Options options=createMock(Options.class);
  expect(options.hash("size")).andReturn(17);
  expect(options.hash("pad"," ")).andReturn("+");
  replay(options);
  assertEquals("ljust",ljust.name());
  assertEquals("Handlebars.java++",ljust.apply("Handlebars.java",options));
  verify(options);
}
