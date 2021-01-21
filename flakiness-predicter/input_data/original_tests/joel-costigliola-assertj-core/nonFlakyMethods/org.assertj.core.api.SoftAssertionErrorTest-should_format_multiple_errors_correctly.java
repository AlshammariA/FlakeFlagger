@Test public void should_format_multiple_errors_correctly(){
  SoftAssertionError error=new SoftAssertionError(Lists.newArrayList("One","Two"));
  assertThat(error.getMessage()).isEqualTo("\nThe following 2 assertions failed:\n1) One\n2) Two\n");
}
