@Test public void customArgumentExtractorWithClassArgShouldBeInstantiated(){
  create("classArgArgumentExtractor").invoke(mockController,context);
  verify(mockController).classArgArgumentExtractor("java.lang.String");
}
