@Test public void should_create_error_message(){
  String message=factory.create(new TestDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \nsome elements are not mutually comparable according to 'CaseInsensitiveStringComparator' comparator in group:\n" + "<[\"b\", \"c\", \"a\"]>");
}
