@Test public void should_pass_if_infinite_iterable_starts_with_given_sequence() throws Exception {
  iterables.assertStartsWith(someInfo(),infiniteListOfNumbers(),array(1,2,3,4,5));
}
