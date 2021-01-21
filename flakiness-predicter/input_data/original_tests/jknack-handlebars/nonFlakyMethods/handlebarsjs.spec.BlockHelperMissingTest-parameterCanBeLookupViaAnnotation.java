@Test public void parameterCanBeLookupViaAnnotation() throws IOException {
  Hash helpers=$("hello",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return "Hello " + options.hash("noun");
    }
  }
);
  Template template=compile("{{hello noun=@world}}",helpers);
  String result=template.apply(Context.newContext($).data("world","world"));
  assertEquals("Hello world",result);
}
