@Test public void should_create_error_message(){
  final Path actual=mock(Path.class);
  final Path other=mock(Path.class);
  String actualMessage=shouldStartWith(actual,other).create(new TestDescription("Test"),new StandardRepresentation());
  assertThat(actualMessage).isEqualTo(String.format("[Test] " + PATH_SHOULD_START_WITH,actual,other));
}
