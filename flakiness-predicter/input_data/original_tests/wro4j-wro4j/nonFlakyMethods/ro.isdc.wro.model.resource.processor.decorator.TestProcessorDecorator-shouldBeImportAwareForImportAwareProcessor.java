@Test public void shouldBeImportAwareForImportAwareProcessor(){
  final ProcessorDecorator decorator=new ProcessorDecorator(new ImportAwareProcessor());
  assertTrue(decorator.isImportAware());
}
