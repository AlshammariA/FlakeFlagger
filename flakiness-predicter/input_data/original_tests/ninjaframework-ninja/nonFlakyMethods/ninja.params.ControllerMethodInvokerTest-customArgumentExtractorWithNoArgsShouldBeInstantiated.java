@Test public void customArgumentExtractorWithNoArgsShouldBeInstantiated(){
  create("noArgArgumentExtractor").invoke(mockController,context);
  verify(mockController).noArgArgumentExtractor("noargs");
}
