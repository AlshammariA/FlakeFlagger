@Test public void should_create_error_message(){
  ErrorMessageFactory factory=shouldHaveAtIndex(newArrayList("Yoda","Luke"),new TestCondition<String>("red lightsaber"),Index.atIndex(1),"Luke");
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <\"Luke\">\nat index <1> to have:\n <red lightsaber>\nin:\n" + " <[\"Yoda\", \"Luke\"]>\n",message);
}
