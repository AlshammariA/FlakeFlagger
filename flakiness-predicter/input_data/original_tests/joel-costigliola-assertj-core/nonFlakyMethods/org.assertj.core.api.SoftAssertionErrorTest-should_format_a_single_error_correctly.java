@Test public void should_format_a_single_error_correctly(){
  SoftAssertionError error=new SoftAssertionError(Lists.newArrayList("One"));
  assertThat(error.getMessage()).isEqualTo("\nThe following assertion failed:\n1) One\n");
}
