@Test public void should_return_are_not_equal_if_first_Object_is_null_and_second_is_not(){
  assertThat(fieldByFieldComparator.compare(null,new JarJar("Yoda"))).isNotZero();
}
