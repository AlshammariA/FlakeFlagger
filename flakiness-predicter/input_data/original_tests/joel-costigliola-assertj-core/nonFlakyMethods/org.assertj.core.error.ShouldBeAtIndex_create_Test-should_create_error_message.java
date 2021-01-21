@Test public void should_create_error_message(){
  ErrorMessageFactory factory=shouldBeAtIndex(newArrayList("Yoda","Luke"),new TestCondition<String>("red lightsaber"),atIndex(1),"Luke");
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <\"Luke\">\nat index <1> to be:\n <red lightsaber>\nin:\n <[\"Yoda\", \"Luke\"]>\n",message);
}
