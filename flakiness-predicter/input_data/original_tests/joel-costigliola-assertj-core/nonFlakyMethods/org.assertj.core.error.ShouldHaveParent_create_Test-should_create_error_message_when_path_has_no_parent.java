@Test public void should_create_error_message_when_path_has_no_parent(){
  final Path actual=mock(Path.class);
  factory=shouldHaveParent(actual,expectedPathParent);
  actualMessage=factory.create(description,representation);
  expectedMessage=String.format("[Test] " + PATH_NO_PARENT,actual,expectedPathParent);
  assertThat(actualMessage).isEqualTo(expectedMessage);
}
