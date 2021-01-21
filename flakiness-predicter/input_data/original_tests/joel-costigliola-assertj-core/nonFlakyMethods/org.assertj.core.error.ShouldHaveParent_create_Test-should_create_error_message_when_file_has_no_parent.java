@Test public void should_create_error_message_when_file_has_no_parent(){
  final File actual=spy(new FakeFile("actual"));
  when(actual.getParentFile()).thenReturn(null);
  factory=shouldHaveParent(actual,expectedFileParent);
  actualMessage=factory.create(description,representation);
  expectedMessage=String.format("[Test] " + FILE_NO_PARENT,actual,expectedFileParent);
  assertThat(actualMessage).isEqualTo(expectedMessage);
}
