@Test(expected=WroRuntimeException.class) public void testInvalidStream() throws Exception {
  factory=new GroovyModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      throw new IOException();
    }
  }
;
  factory.create();
}
