@Test public void should_create_error_message(){
  final Path actual=mock(Path.class);
  ErrorMessageFactory factory=shouldBeNormalized(actual);
  String actualMessage=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(actualMessage).isEqualTo(format("[Test] " + SHOULD_BE_NORMALIZED,actual));
}
