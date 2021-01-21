@Test public void shouldSupportAbstractGroup(){
  factory=new GroovyModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return getClass().getResourceAsStream("abstractGroup.groovy");
    }
  }
;
  final WroModel model=factory.create();
  assertNotNull(model);
  assertEquals(1,model.getGroups().size());
  final Group group=model.getGroups().iterator().next();
  assertEquals("nonAbstractGroup",group.getName());
  assertEquals(1,group.getResources().size());
}
