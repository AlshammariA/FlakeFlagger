@Test public void should_set_description(){
  assertions.describedAs(description);
  assertThat(assertions.descriptionText()).isEqualTo(description.value());
}
