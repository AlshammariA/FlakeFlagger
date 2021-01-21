@Test public void centerWithPad() throws IOException {
  Options options=createMock(Options.class);
  expect(options.hash("size")).andReturn(19);
  expect(options.hash("pad"," ")).andReturn("*");
  replay(options);
  assertEquals("center",center.name());
  assertEquals("**Handlebars.java**",center.apply("Handlebars.java",options));
  verify(options);
}
