/** 
 * Test the usecase when the resource has no URI.
 */
@Test(expected=WroRuntimeException.class) public void createIncompleteModel(){
  factory=new GroovyModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return getClass().getResourceAsStream("IncompleteWro.groovy");
    }
  }
;
  factory.create();
}
