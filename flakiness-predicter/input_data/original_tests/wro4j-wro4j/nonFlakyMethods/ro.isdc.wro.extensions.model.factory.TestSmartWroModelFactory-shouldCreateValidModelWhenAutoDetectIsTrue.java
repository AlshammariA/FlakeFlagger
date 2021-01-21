@Test public void shouldCreateValidModelWhenAutoDetectIsTrue() throws Exception {
  factory=new SmartWroModelFactory();
  final File wroFile=new File(getClass().getResource("subfolder/wro.json").toURI());
  factory.setWroFile(wroFile).setAutoDetectWroFile(true);
  injector.inject(factory);
  Assert.assertNotNull(factory.create());
}
