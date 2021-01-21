@Test public void shouldNotBeImportAwareForDefaultProcessor(){
  final ProcessorDecorator decorator=new ProcessorDecorator(mockProcessor);
  assertFalse(decorator.isImportAware());
}
