@Test public void should_create_error_message(){
  String message=factory.create(new TestDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <\"Yoda\">\nto be of one these types:\n <[java.lang.Long, java.io.File]>\nbut was:\n <java.lang.String>",message);
}
