@Test public void should_create_error_message(){
  ErrorMessageFactory factory=shouldContainAtIndex(newArrayList("Yoda","Luke"),"Leia",atIndex(1),"Luke");
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <\"Leia\">\nat index <1> but found:\n <\"Luke\">\nin:\n <[\"Yoda\", \"Luke\"]>\n",message);
}
