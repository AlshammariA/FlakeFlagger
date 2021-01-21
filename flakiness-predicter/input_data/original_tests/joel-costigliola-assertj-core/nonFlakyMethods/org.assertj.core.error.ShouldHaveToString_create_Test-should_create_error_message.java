@Test public void should_create_error_message() throws Exception {
  String actual="c++";
  String expectedToString="java";
  String errorMessage=shouldHaveToString(actual,expectedToString).create(new TestDescription("TEST"),new StandardRepresentation());
  assertThat(errorMessage).isEqualTo(format("[TEST] %n" + "Expecting actual's toString() to return:%n" + "  <\"java\">%n"+ "but was:%n"+ "  <\"c++\">"));
}
