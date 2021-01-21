@Test public void should_create_error_message_for_Path_following_symbolic_links(){
  final Path actual=mock(Path.class);
  factory=shouldExist(actual);
  actualMessage=factory.create(description,representation);
  expectedMessage=String.format("[Test] " + PATH_SHOULD_EXIST,actual);
  assertThat(actualMessage).isEqualTo(expectedMessage);
}
