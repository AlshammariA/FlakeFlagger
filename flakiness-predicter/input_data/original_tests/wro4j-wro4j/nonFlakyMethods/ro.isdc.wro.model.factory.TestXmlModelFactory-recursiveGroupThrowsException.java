@Test(expected=RecursiveGroupDefinitionException.class) public void recursiveGroupThrowsException(){
  factory=new XmlModelFactory(){
    @Override protected InputStream getModelResourceAsStream(){
      return Thread.currentThread().getContextClassLoader().getResourceAsStream("recursive.xml");
    }
  }
;
  factory.create();
}
