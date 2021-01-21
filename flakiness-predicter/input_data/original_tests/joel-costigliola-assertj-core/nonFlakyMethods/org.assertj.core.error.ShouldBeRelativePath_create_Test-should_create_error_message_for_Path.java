@Test public void should_create_error_message_for_Path() throws IOException {
  final Path path=mock(Path.class);
  ErrorMessageFactory factory=shouldBeRelativePath(path);
  String message=factory.create(TEST_DESCRIPTION,STANDARD_REPRESENTATION);
  assertThat(message).isEqualTo(format("[Test] " + SHOULD_BE_RELATIVE_PATH,path));
}
