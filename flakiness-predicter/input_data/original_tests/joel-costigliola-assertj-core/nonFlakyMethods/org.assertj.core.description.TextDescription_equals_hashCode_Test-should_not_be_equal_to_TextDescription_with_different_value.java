@Test public void should_not_be_equal_to_TextDescription_with_different_value(){
  assertFalse(description.equals(new TextDescription("Luke")));
}
