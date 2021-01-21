@Test(expected=RecursiveGroupDefinitionException.class) public void testRecursiveGroupReference(){
  factory=new GroovyModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return getClass().getResourceAsStream("wroRecursiveReference.groovy");
    }
  }
;
  factory.create();
}
