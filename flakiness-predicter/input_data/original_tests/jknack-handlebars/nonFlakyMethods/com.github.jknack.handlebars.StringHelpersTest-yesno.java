@Test public void yesno() throws IOException {
  Options options=createMock(Options.class);
  expect(options.hash("yes","yes")).andReturn("yes");
  expect(options.hash("no","no")).andReturn("no");
  expect(options.hash("maybe","maybe")).andReturn("maybe");
  replay(options);
  assertEquals("yesno",yesno.name());
  assertEquals("yes",yesno.apply(true,options));
  assertEquals("no",yesno.apply(false,options));
  assertEquals("maybe",yesno.apply(null,options));
  verify(options);
}
