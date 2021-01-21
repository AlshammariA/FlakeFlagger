@Test public void wordWrap() throws IOException {
  Options options=createMock(Options.class);
  expect(options.param(0,null)).andReturn(5);
  replay(options);
  assertEquals("wordWrap",wordWrap.name());
  assertEquals("Joel" + SystemUtils.LINE_SEPARATOR + "is a"+ SystemUtils.LINE_SEPARATOR+ "slug",wordWrap.apply("Joel is a slug",options));
  verify(options);
}
