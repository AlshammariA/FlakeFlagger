@Test public void yesnoCustom() throws IOException {
  Options options=createMock(Options.class);
  expect(options.hash("yes","yes")).andReturn("yea");
  expect(options.hash("no","no")).andReturn("nop");
  expect(options.hash("maybe","maybe")).andReturn("whatever");
  replay(options);
  assertEquals("yesno",yesno.name());
  assertEquals("yea",yesno.apply(true,options));
  assertEquals("nop",yesno.apply(false,options));
  assertEquals("whatever",yesno.apply(null,options));
  verify(options);
}
