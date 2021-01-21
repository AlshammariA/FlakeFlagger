@Test public void upper() throws IOException {
  Options options=createMock(Options.class);
  replay(options);
  assertEquals("upper",upper.name());
  assertEquals("HANDLEBARS.JAVA",upper.apply("Handlebars.java",options));
  verify(options);
}
