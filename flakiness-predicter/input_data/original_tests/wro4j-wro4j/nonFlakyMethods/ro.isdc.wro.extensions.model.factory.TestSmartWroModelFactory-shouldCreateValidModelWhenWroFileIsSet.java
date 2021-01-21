@Test public void shouldCreateValidModelWhenWroFileIsSet() throws Exception {
  factory=new SmartWroModelFactory();
  final File wroFile=new File(getClass().getResource("wro.xml").toURI());
  factory.setWroFile(wroFile);
  injector.inject(factory);
  Assert.assertNotNull(factory.create());
}
