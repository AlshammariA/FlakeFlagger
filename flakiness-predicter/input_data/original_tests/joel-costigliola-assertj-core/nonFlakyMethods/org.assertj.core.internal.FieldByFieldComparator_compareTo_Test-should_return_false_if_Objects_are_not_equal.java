@Test public void should_return_false_if_Objects_are_not_equal(){
  assertThat(fieldByFieldComparator.compare(new JarJar("Yoda"),new JarJar("HanSolo"))).isNotZero();
}
