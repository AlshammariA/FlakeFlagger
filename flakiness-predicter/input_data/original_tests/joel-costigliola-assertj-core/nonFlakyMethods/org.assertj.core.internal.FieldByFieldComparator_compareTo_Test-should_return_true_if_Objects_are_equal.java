@Test public void should_return_true_if_Objects_are_equal(){
  assertThat(fieldByFieldComparator.compare(new JarJar("Yoda"),new JarJar("Yoda"))).isZero();
}
