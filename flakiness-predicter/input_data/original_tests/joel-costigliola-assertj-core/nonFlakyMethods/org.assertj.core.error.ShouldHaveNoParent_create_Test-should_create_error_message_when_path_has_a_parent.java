@Test public void should_create_error_message_when_path_has_a_parent(){
  final Path path=mock(Path.class);
  final Path parent=mock(Path.class);
  when(path.getParent()).thenReturn(parent);
  factory=shouldHaveNoParent(path);
  actualMessage=factory.create(description,representation);
  expectedMessage=String.format("[Test] " + PATH_HAS_PARENT,path,parent);
  assertThat(actualMessage).isEqualTo(expectedMessage);
}
