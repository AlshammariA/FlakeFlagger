@Test public void should_create_error_message(){
  String message=factory.create(new TestDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <\"Yoda\">\nnot to have not the same class as:\n <\"Luke\"> (java.lang.String)",message);
}
