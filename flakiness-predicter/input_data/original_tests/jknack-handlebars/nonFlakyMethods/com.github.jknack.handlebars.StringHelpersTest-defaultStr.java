@Test public void defaultStr() throws IOException {
  Options options=createMock(Options.class);
  expect(options.param(0,"")).andReturn("handlebars.java").anyTimes();
  replay(options);
  assertEquals("defaultIfEmpty",defaultIfEmpty.name());
  assertEquals("handlebars.java",defaultIfEmpty.apply(null,options));
  assertEquals("handlebars.java",defaultIfEmpty.apply(false,options));
  assertEquals("handlebars.java",defaultIfEmpty.apply(Collections.emptyList(),options));
  assertEquals("something",defaultIfEmpty.apply("something",options));
  verify(options);
}
