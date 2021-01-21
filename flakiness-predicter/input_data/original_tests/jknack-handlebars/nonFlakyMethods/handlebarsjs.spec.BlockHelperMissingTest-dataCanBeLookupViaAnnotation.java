@Test public void dataCanBeLookupViaAnnotation() throws IOException {
  Template template=compile("{{@hello}}");
  String result=template.apply(Context.newContext($).data("hello","hello"));
  assertEquals("hello",result);
}
