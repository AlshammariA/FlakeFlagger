@Test public void should_create_error_message_for_Path_not_following_symbolic_links(){
  final Path actual=mock(Path.class);
  factory=shouldExistNoFollowLinks(actual);
  actualMessage=factory.create(description,representation);
  expectedMessage=String.format("[Test] " + PATH_SHOULD_EXIST_NO_FOLLOW_LINKS,actual);
  assertThat(actualMessage).isEqualTo(expectedMessage);
}
