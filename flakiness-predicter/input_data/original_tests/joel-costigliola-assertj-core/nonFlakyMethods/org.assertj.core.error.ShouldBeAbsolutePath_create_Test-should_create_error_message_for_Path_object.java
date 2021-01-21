@Test public void should_create_error_message_for_Path_object(){
  final Path path=mock(Path.class);
  factory=shouldBeAbsolutePath(path);
  actualMessage=factory.create(description,representation);
  assertThat(actualMessage).isEqualTo(format("[Test] " + SHOULD_BE_ABSOLUTE_PATH,path));
}
