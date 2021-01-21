@Test(expected=WroRuntimeException.class) public void testDuplicateGroupName(){
  factory=new GroovyModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return getClass().getResourceAsStream("wroDuplicateGroupName.groovy");
    }
  }
;
  factory.create();
}
