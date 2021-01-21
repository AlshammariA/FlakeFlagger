@Test public void createGroupReferenceOrderShouldNotMatter(){
  factory=new GroovyModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return getClass().getResourceAsStream("wroGroupRefOrder.groovy");
    }
  }
;
  Assert.assertNotNull(factory.create());
}
