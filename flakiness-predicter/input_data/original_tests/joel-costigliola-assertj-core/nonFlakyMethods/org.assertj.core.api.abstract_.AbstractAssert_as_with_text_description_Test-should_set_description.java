@Test public void should_set_description(){
  assertions.as(description);
  assertThat(assertions.descriptionText()).isEqualTo(description);
}
