@Test public void should_create_error_message_for_iterable(){
  List<Object> list=new ArrayList<>();
  list.add("Yoda");
  list.add(5L);
  ErrorMessageFactory factory=shouldHaveOnlyElementsOfType(list,String.class,Long.class);
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo(String.format("[Test] %n" + "Expecting:%n" + "  <[\"Yoda\", 5L]>%n"+ "to only have elements of type:%n"+ "  <java.lang.String>%n"+ "but found:%n"+ "  <java.lang.Long>"));
}
