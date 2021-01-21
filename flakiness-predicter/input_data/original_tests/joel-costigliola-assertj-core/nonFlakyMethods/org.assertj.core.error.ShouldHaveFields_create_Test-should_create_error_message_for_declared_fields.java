@Test public void should_create_error_message_for_declared_fields(){
  ErrorMessageFactory factory=shouldHaveDeclaredFields(Person.class,newLinkedHashSet("name","address"),newLinkedHashSet("address"));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting\n" + "  <org.assertj.core.test.Person>\n"+ "to have declared fields:\n"+ "  <[\"name\", \"address\"]>\n"+ "but it doesn't have:\n"+ "  <[\"address\"]>");
}
