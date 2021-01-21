@Test public void should_create_error_message_for_Path_object(){
  final Path path=mock(Path.class);
  factory=shouldNotExist(path);
  actualMessage=factory.create(description,representation);
  expectedMessage=String.format("[Test] " + PATH_SHOULD_NOT_EXIST,path);
  assertThat(actualMessage).isEqualTo(expectedMessage);
}
