@Test public void should_create_error_message_when_file_does_not_have_expected_parent(){
  final File actual=spy(new FakeFile("actual"));
  final FakeFile actualParent=new FakeFile("not.expected.parent");
  when(actual.getParentFile()).thenReturn(actualParent);
  factory=shouldHaveParent(actual,expectedFileParent);
  actualMessage=factory.create(description,representation);
  expectedMessage=String.format("[Test] " + FILE_NOT_EXPECTED_PARENT,actual,expectedFileParent,actualParent);
  assertThat(actualMessage).isEqualTo(expectedMessage);
}
