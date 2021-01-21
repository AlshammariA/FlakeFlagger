@Test(expected=WroRuntimeException.class) public void testWithInvalidWroFileSet() throws Exception {
  final File wroFile=new File("/path/to/invalid/wro.xml");
  factory=new SmartWroModelFactory().setWroFile(wroFile);
  injector.inject(factory);
  Assert.assertNotNull(factory.create());
}
