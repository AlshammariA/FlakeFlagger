@Test public void customArgumentExtractorWithGuiceShouldBeInstantiated(){
  create("guiceArgumentExtractor",new Dep("dep")).invoke(mockController,context);
  verify(mockController).guiceArgumentExtractor("dep:bar:java.lang.String");
}
