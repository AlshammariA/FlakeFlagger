@Test public void should_return_hashCode_of_given_Object(){
  assertThat(hashCodeFor("Yoda")).isEqualTo("Yoda".hashCode());
}
