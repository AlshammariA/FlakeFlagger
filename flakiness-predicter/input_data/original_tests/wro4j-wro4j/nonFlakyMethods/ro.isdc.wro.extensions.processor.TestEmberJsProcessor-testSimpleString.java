@Test public void testSimpleString() throws Exception {
  final StringWriter writer=new StringWriter();
  processor.process(null,new StringReader("Hello {name}!"),writer);
  final String result=writer.toString();
  assertTrue(result.startsWith("(function() {Ember.TEMPLATES["));
  assertTrue(result.contains("data.buffer.push(\"Hello {name}!\\n\");"));
}
