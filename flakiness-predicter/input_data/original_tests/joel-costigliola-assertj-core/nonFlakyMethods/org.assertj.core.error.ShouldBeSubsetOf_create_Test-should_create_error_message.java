@Test public void should_create_error_message(){
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \nExpecting :\n <[\"Yoda\", \"Luke\"]>\nto be subset of\n <[\"Han\", \"Luke\"]>\nbut found these extra elements:\n <[\"Yoda\"]>");
}
