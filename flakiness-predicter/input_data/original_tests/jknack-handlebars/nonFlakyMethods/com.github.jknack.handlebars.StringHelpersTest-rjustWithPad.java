@Test public void rjustWithPad() throws IOException {
  Options options=createMock(Options.class);
  expect(options.hash("size")).andReturn(17);
  expect(options.hash("pad"," ")).andReturn("+");
  replay(options);
  assertEquals("rjust",rjust.name());
  assertEquals("++Handlebars.java",rjust.apply("Handlebars.java",options));
  verify(options);
}
