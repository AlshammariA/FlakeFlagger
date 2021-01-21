@Test public void should_create_error_message(){
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting\n" + "  <org.assertj.core.error.ShouldHaveAnnotations_create_Test>\n"+ "to have annotations:\n"+ "  <[java.lang.Override, java.lang.Deprecated]>\n"+ "but the following annotations were not found:\n"+ "  <[java.lang.SuppressWarnings]>");
}
