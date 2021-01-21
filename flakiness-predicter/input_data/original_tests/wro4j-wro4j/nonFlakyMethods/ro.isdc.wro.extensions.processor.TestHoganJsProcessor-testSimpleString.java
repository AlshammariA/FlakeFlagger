@Test public void testSimpleString() throws Exception {
  final StringWriter writer=new StringWriter();
  processor.process(Resource.create("template.js"),new StringReader("Hello {{name}}!"),writer);
  final String result=writer.toString();
  assertTrue(result.contains("Hogan.cache['template']"));
}
