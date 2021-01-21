@Test public void createValidModel(){
  factory=new JsonModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return TestGroovyModelFactory.class.getResourceAsStream("wro.json");
    }
  }
;
  final WroModel model=factory.create();
  Assert.assertNotNull(model);
  Assert.assertEquals(Arrays.asList("g1","g2"),new WroModelInspector(model).getGroupNames());
  LOG.debug("model: {}",model);
}
